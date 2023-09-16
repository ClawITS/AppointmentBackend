package com.app.appointment_app.doctor.infraestructure.entry_point;
import com.app.appointment_app.doctor.domain.exceptions.AcceptPatientRescheduleException;
import com.app.appointment_app.doctor.domain.exceptions.DoctorException;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.domain.requests.AcceptPatientReschedulingRequest;
import com.app.appointment_app.doctor.domain.requests.RescheduleAppointmentRequest;
import com.app.appointment_app.doctor.domain.responses.AcceptPatientReschedulingResponse;
import com.app.appointment_app.doctor.domain.responses.RescheduleAppointmentResponse;
import com.app.appointment_app.doctor.infraestructure.entry_point.provider.DoctorProvider;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
   private final DoctorProvider doctorProvider;

    public DoctorController(DoctorProvider doctorProvider) {
        this.doctorProvider = doctorProvider;
    }


    @PostMapping
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorProvider
                .getDoctorSaveUseCase().saveDoctor(doctor), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctorById(@PathVariable Long id) {
        doctorProvider.getDoctorDeleteUseCase().deleteDoctorById(id);
        return new ResponseEntity<>("The doctor with id " + id + " has been deleted succesfuly", HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findDoctorById(@PathVariable Long id) {
        return new ResponseEntity<>(doctorProvider
                .getDoctorFindByIdUseCase().findDoctorById(id), HttpStatus.OK);
    }

    @GetMapping("/page/{numberPage}")
    public ResponseEntity<Page<Doctor>> findAllPageDoctors(@PathVariable int numberPage) {
        return new ResponseEntity<>(doctorProvider
                .getDoctorFindAllUseCase().findAllDoctorsPaginator(numberPage), HttpStatus.OK);
    }

    @PostMapping("/rescheduleAppointment")
    public ResponseEntity<RescheduleAppointmentResponse> rescheduleAppointment(@RequestBody RescheduleAppointmentRequest
                                                                                       rescheduleAppointmentRequest) {
        return new ResponseEntity<>(doctorProvider.getRescheduleAppointmentUseCase()
                .rescheduleAppointment(rescheduleAppointmentRequest),
                HttpStatus.OK);
    }

    @PostMapping("/acceptRescheduling")
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
