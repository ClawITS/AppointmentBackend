package com.app.appointment_app.patient.infraestructure.entry_point;

import com.app.appointment_app.appointment.domain.exceptions.AcceptReschedulingException;
import com.app.appointment_app.appointment.domain.exceptions.AppointmentException;
import com.app.appointment_app.appointment.domain.exceptions.CancelReschedulingException;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.patient.domain.model.Patient;
import com.app.appointment_app.patient.domain.usecases.*;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientResheduleUseCase patientResheduleUseCase;
    private final PatientSaveUseCase patientSaveUseCase;
    private final AcceptReschedulingUseCase acceptReschedulingUseCase;
    private final PatientFindAllUseCase patientFindAllUseCase;
    private final PatientFindByIdUseCase patientFindByIdUseCase;
    private final PatientDeleteUseCase patientDeleteUseCase;
    private final CancelReschedulingUseCase cancelReschedulingUseCase;

    public PatientController(PatientResheduleUseCase patientResheduleUseCase, PatientSaveUseCase patientSaveUseCase,
                             AcceptReschedulingUseCase acceptReschedulingUseCase, PatientFindAllUseCase patientFindAllUseCase,
                             PatientFindByIdUseCase patientFindByIdUseCase, PatientDeleteUseCase patientDeleteUseCase,
                             CancelReschedulingUseCase cancelReschedulingUseCase) {
        this.patientResheduleUseCase = patientResheduleUseCase;
        this.patientSaveUseCase = patientSaveUseCase;
        this.acceptReschedulingUseCase = acceptReschedulingUseCase;
        this.patientFindAllUseCase = patientFindAllUseCase;
        this.patientFindByIdUseCase = patientFindByIdUseCase;
        this.patientDeleteUseCase = patientDeleteUseCase;
        this.cancelReschedulingUseCase = cancelReschedulingUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id) {
        return new ResponseEntity<>(patientFindByIdUseCase.findPatientById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientSaveUseCase.savePatient(patient), HttpStatus.CREATED);
    }
    @PostMapping("/acceptRescheduling")
    public ResponseEntity<?> acceptRescheduling(@RequestBody Appointment appointment){
        try {
            AcceptReschedulingException.invalidStateToRescheduling(appointment);
            return new ResponseEntity<>(acceptReschedulingUseCase.acceptRescheduling(appointment),HttpStatus.OK);
        }catch (AppointmentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }

    }

    @GetMapping("/page/{numberPage}")
    public ResponseEntity<Page<Patient>> getPatientPage(@PathVariable int numberPage) {
        return new ResponseEntity<>(patientFindAllUseCase.findAllPatientPaginator(numberPage), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable Long id) {
        patientDeleteUseCase.deletePatientById(id);
        return new ResponseEntity<>("the entity with id " + id + " has been deleted", HttpStatus.OK);
    }

    @PostMapping("/cancelRescheduling")
    public ResponseEntity<?> cancelRescheduling(@RequestBody Appointment appointment){
        try{
            CancelReschedulingException.cancelReschedulingException(appointment);
            return new ResponseEntity<>(cancelReschedulingUseCase.cancelRescheduling(appointment), HttpStatus.OK);
        }catch(AppointmentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }

    }
@PostMapping("/patienReshedule")
    public  ResponseEntity <?> patientReshedule(@RequestBody Appointment appointment){
        return new ResponseEntity<>(patientResheduleUseCase.patientReschedule(appointment),HttpStatus.OK);
}

}
