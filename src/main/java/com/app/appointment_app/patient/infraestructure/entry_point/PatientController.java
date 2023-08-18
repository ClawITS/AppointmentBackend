package com.app.appointment_app.patient.infraestructure.entry_point;

import com.app.appointment_app.patient.domain.model.Patient;
import com.app.appointment_app.patient.domain.usecases.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {
    private PatientSaveUseCase patientSaveUseCase;
    private PatientFindAllUseCase patientFindAllUseCase;
    private PatientFindByIdUseCase patientFindByIdUseCase;
    private PatientDeleteUseCase patientDeleteUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id) {
        return new ResponseEntity<>(patientFindByIdUseCase.findpatientById(id), HttpStatus.OK);
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
