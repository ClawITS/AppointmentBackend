package com.app.appointment_app.doctor.infraestructure.entry_point;
import com.app.appointment_app.commons.infraestructure.rest.dto.response.CustomResponse;
import com.app.appointment_app.commons.infraestructure.rest.entry_points.controller.GenericRestController;
import com.app.appointment_app.doctor.domain.exceptions.AcceptPatientRescheduleException;
import com.app.appointment_app.doctor.domain.exceptions.DoctorException;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.domain.dto.requests.AcceptPatientReschedulingRequest;
import com.app.appointment_app.doctor.domain.dto.requests.RescheduleAppointmentRequest;
import com.app.appointment_app.doctor.domain.dto.mappers.DoctorResponseMapper;
import com.app.appointment_app.doctor.domain.dto.response.AcceptPatientReschedulingResponse;
import com.app.appointment_app.doctor.domain.dto.response.RescheduleAppointmentResponse;
import com.app.appointment_app.doctor.infraestructure.entry_point.provider.DoctorProvider;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.app.appointment_app.doctor.infraestructure.entry_point.constants.DoctorApiConstants.REQUEST_DOCTOR;
import static com.app.appointment_app.doctor.infraestructure.entry_point.constants.DoctorResponseConstants.DOCTOR_SAVED;

@RestController
@RequestMapping(REQUEST_DOCTOR)
public class DoctorController extends GenericRestController implements IDoctorController {
   private final DoctorProvider doctorProvider;

    public DoctorController(DoctorProvider doctorProvider) {
        this.doctorProvider = doctorProvider;
    }

    @Override
    public ResponseEntity<CustomResponse> saveDoctor(@RequestBody Doctor doctor) {
        return ok(doctorProvider
                        .getDoctorSaveUseCase().saveDoctor(doctor),DOCTOR_SAVED,
                REQUEST_DOCTOR);
    }

    @Override
    public ResponseEntity<String> deleteDoctorById(@PathVariable Long id) {
        doctorProvider.getDoctorDeleteUseCase().deleteDoctorById(id);
        return new ResponseEntity<>("The doctor with id " + id + " has been deleted succesfuly", HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Doctor> findDoctorById(@PathVariable Long id) {
        return new ResponseEntity<>(doctorProvider
                .getDoctorFindByIdUseCase().findDoctorById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<Doctor>> findAllPageDoctors(@PathVariable int numberPage) {
        return new ResponseEntity<>(doctorProvider
                .getDoctorFindAllUseCase().findAllDoctorsPaginator(numberPage), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RescheduleAppointmentResponse> rescheduleAppointment(@RequestBody RescheduleAppointmentRequest
                                                                                       rescheduleAppointmentRequest) {
        return new ResponseEntity<>(doctorProvider.getRescheduleAppointmentUseCase()
                .rescheduleAppointment(rescheduleAppointmentRequest),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AcceptPatientReschedulingResponse> acceptReschedule(@RequestBody AcceptPatientReschedulingRequest acceptPatientReschedulingRequest) {
        try{
            AcceptPatientRescheduleException.invalidState(acceptPatientReschedulingRequest);
            return new ResponseEntity<>(doctorProvider
                    .getAcceptPatientReschedulingUseCase().acceptPatientRescheduling(acceptPatientReschedulingRequest),
                    HttpStatus.OK);
        }catch(DoctorException e){
            return ResponseEntity.badRequest().body(new AcceptPatientReschedulingResponse(e.getMessage()));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AcceptPatientReschedulingResponse(e.getMessage()));
        }

    }

}
