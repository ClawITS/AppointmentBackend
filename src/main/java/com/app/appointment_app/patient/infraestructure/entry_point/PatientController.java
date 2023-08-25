package com.app.appointment_app.patient.infraestructure.entry_point;

import com.app.appointment_app.patient.domain.model.Patient;
import com.app.appointment_app.patient.domain.usecases.PatientDeleteUseCase;
import com.app.appointment_app.patient.domain.usecases.PatientFindAllUseCase;
import com.app.appointment_app.patient.domain.usecases.PatientFindByIdUseCase;
import com.app.appointment_app.patient.domain.usecases.PatientSaveUseCase;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientSaveUseCase patientSaveUseCase;
    private final PatientFindAllUseCase patientFindAllUseCase;
    private final PatientFindByIdUseCase patientFindByIdUseCase;
    private final PatientDeleteUseCase patientDeleteUseCase;

    public PatientController(PatientSaveUseCase patientSaveUseCase, PatientFindAllUseCase patientFindAllUseCase, PatientFindByIdUseCase patientFindByIdUseCase, PatientDeleteUseCase patientDeleteUseCase) {
        this.patientSaveUseCase = patientSaveUseCase;
        this.patientFindAllUseCase = patientFindAllUseCase;
        this.patientFindByIdUseCase = patientFindByIdUseCase;
        this.patientDeleteUseCase = patientDeleteUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id) {
        return new ResponseEntity<>(patientFindByIdUseCase.findPatientById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientSaveUseCase.savePatient(patient), HttpStatus.CREATED);
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
}
