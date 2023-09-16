package com.app.appointment_app.patient.infraestructure.entry_point;

import com.app.appointment_app.appointment.domain.exceptions.AcceptReschedulingException;
import com.app.appointment_app.appointment.domain.exceptions.AppointmentException;
import com.app.appointment_app.appointment.domain.exceptions.CancelReschedulingException;
import com.app.appointment_app.patient.domain.model.Patient;
import com.app.appointment_app.patient.domain.requests.AcceptReschedulingRequest;
import com.app.appointment_app.patient.domain.requests.CancelReschedulingRequest;
import com.app.appointment_app.patient.domain.requests.PatientFilterByNameRequest;
import com.app.appointment_app.patient.domain.requests.PatientRescheduleRequest;
import com.app.appointment_app.patient.domain.responses.AcceptReschedulingResponse;
import com.app.appointment_app.patient.domain.responses.CancelReschedulingResponse;
import com.app.appointment_app.patient.domain.responses.PatientRescheduleResponse;
import com.app.appointment_app.patient.infraestructure.entry_point.provider.PatientProvider;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientProvider patientProvider;

    public PatientController(PatientProvider patientProvider) {
        this.patientProvider = patientProvider;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id) {
        return new ResponseEntity<>(patientProvider
                .getPatientFindByIdUseCase().findPatientById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientProvider
                .getPatientSaveUseCase().savePatient(patient), HttpStatus.CREATED);
    }
    @PostMapping("/acceptRescheduling")
    public ResponseEntity<AcceptReschedulingResponse> acceptRescheduling(@RequestBody AcceptReschedulingRequest acceptReschedulingRequest){
        try {
            AcceptReschedulingException.invalidStateToRescheduling(acceptReschedulingRequest);
            return new ResponseEntity<>(patientProvider
                    .getAcceptReschedulingUseCase().acceptRescheduling(acceptReschedulingRequest),HttpStatus.OK);
        }catch (AppointmentException e){
            return ResponseEntity.badRequest().body(new AcceptReschedulingResponse(e.getMessage()));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new AcceptReschedulingResponse(e.getMessage()));
        }

    }

    @GetMapping("/page/{numberPage}")
    public ResponseEntity<Page<Patient>> getPatientPage(@PathVariable int numberPage) {
        return new ResponseEntity<>(patientProvider
                .getPatientFindAllUseCase().findAllPatientPaginator(numberPage), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable Long id) {
        patientProvider.getPatientDeleteUseCase().deletePatientById(id);
        return new ResponseEntity<>("the entity with id " + id + " has been deleted", HttpStatus.OK);
    }

    @PostMapping("/cancelRescheduling")
    public ResponseEntity<CancelReschedulingResponse> cancelRescheduling(@RequestBody CancelReschedulingRequest cancelReschedulingRequest){
        try{
            CancelReschedulingException.cancelReschedulingException(cancelReschedulingRequest);
            return new ResponseEntity<>(patientProvider
                    .getCancelReschedulingUseCase().cancelRescheduling(cancelReschedulingRequest), HttpStatus.OK);
        }catch(AppointmentException e){
            return ResponseEntity.badRequest().body(new CancelReschedulingResponse(e.getMessage()));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CancelReschedulingResponse(e.getMessage()));
        }

    }
    @PostMapping("/patientReshedule")
        public  ResponseEntity <PatientRescheduleResponse> patientReshedule(@RequestBody PatientRescheduleRequest patientRescheduleRequest){
            return new ResponseEntity<>(patientProvider
                    .getPatientResheduleUseCase().patientReschedule(patientRescheduleRequest),HttpStatus.OK);
    }

    @PostMapping("/fileredByName")
    public ResponseEntity<List<Patient>> patientsFilteredByName(@RequestBody PatientFilterByNameRequest patientFilterByNameRequest) {
        return new ResponseEntity<>(patientProvider.getPatientFilterByNameUseCase()
                .filterPatientsByName(patientFilterByNameRequest), HttpStatus.OK);
    }
}
