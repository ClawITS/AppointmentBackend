package com.app.appointmentapp.doctor.infraestructure.entry_point;
import com.app.appointmentapp.commons.infraestructure.rest.dto.response.CustomResponse;
import com.app.appointmentapp.commons.infraestructure.rest.entry_points.controller.GenericRestController;
import com.app.appointmentapp.doctor.domain.dto.response.DoctorResponse;
import com.app.appointmentapp.doctor.domain.exceptions.AcceptPatientRescheduleException;
import com.app.appointmentapp.doctor.domain.exceptions.DoctorException;
import com.app.appointmentapp.doctor.domain.model.Doctor;
import com.app.appointmentapp.doctor.domain.dto.requests.AcceptPatientReschedulingRequest;
import com.app.appointmentapp.doctor.domain.dto.requests.RescheduleAppointmentRequest;
import com.app.appointmentapp.doctor.domain.dto.response.AcceptPatientReschedulingResponse;
import com.app.appointmentapp.doctor.domain.dto.response.RescheduleAppointmentResponse;
import com.app.appointmentapp.doctor.infraestructure.entry_point.provider.DoctorProvider;
import com.app.appointmentapp.doctor.infraestructure.entry_point.validate.ValidateDoctor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import static com.app.appointmentapp.doctor.infraestructure.entry_point.constants.DoctorApiConstants.REQUEST_DOCTOR;
import static com.app.appointmentapp.doctor.infraestructure.entry_point.constants.DoctorResponseConstants.DOCTOR_SAVED;

@RestController
@RequestMapping(REQUEST_DOCTOR)
public class DoctorController extends GenericRestController implements IDoctorController {
   private final DoctorProvider doctorProvider;

    public DoctorController(DoctorProvider doctorProvider) {
        this.doctorProvider = doctorProvider;
    }

    @Override
    public ResponseEntity<CustomResponse> saveDoctor(@RequestBody Doctor doctor, BindingResult bindingResult) {
        ValidateDoctor.validateDoctorFields(doctor, bindingResult);
        if(bindingResult.hasErrors()){
            return bad(doctor,bindingResult.getFieldError().getDefaultMessage(), REQUEST_DOCTOR);
        }
        DoctorResponse doctorResponse = doctorProvider.getDoctorSaveUseCase().saveDoctor(doctor);
        if(doctorResponse.getName() == null){
            return bad(null, doctorResponse.getDescription(),REQUEST_DOCTOR);
        }
        return create(doctorResponse,DOCTOR_SAVED,
                REQUEST_DOCTOR);
    }

    @Override
    public ResponseEntity<String> deleteDoctorById(@PathVariable Long id) {
        doctorProvider.getDoctorDeleteUseCase().deleteDoctorById(id);
        return new ResponseEntity<>("The doctor with id " + id + " has been deleted succesfuly", HttpStatus.OK);

    }

    @Override
    public ResponseEntity<CustomResponse> findDoctorById(@PathVariable Long id) {
        return ok(doctorProvider.doctorFindedMapper().toDoctorFindedResponse(doctorProvider
                        .getDoctorFindByIdUseCase().findDoctorById(id)),
                "doctor finded", REQUEST_DOCTOR);
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
