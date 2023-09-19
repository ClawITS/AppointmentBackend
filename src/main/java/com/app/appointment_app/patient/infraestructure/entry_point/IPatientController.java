package com.app.appointment_app.patient.infraestructure.entry_point;

import com.app.appointment_app.commons.infraestructure.rest.dto.response.CustomResponse;
import com.app.appointment_app.patient.domain.model.Patient;
import com.app.appointment_app.patient.domain.requests.AcceptReschedulingRequest;
import com.app.appointment_app.patient.domain.requests.CancelReschedulingRequest;
import com.app.appointment_app.patient.domain.requests.PatientFilterByNameRequest;
import com.app.appointment_app.patient.domain.requests.PatientRescheduleRequest;
import com.app.appointment_app.patient.domain.responses.AcceptReschedulingResponse;
import com.app.appointment_app.patient.domain.responses.CancelReschedulingResponse;
import com.app.appointment_app.patient.domain.responses.PatientRescheduleResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IPatientController {
    @GetMapping("/{id}")
    ResponseEntity<Patient> findById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<CustomResponse> save(@RequestBody Patient patient);

    @PostMapping("/acceptRescheduling")
    ResponseEntity<AcceptReschedulingResponse> acceptRescheduling(@RequestBody AcceptReschedulingRequest acceptReschedulingRequest);

    @GetMapping("/page/{numberPage}")
    ResponseEntity<Page<Patient>> getPatientPage(@PathVariable int numberPage);

    @DeleteMapping("/{id}")
    ResponseEntity<String> deletePatientById(@PathVariable Long id);

    @PostMapping("/cancelRescheduling")
    ResponseEntity<CancelReschedulingResponse> cancelRescheduling(@RequestBody CancelReschedulingRequest cancelReschedulingRequest);

    @PostMapping("/patientReshedule")
    ResponseEntity<PatientRescheduleResponse> patientReshedule(@RequestBody PatientRescheduleRequest patientRescheduleRequest);

    @PostMapping("/fileredByName")
    ResponseEntity<List<Patient>> patientsFilteredByName(@RequestBody PatientFilterByNameRequest patientFilterByNameRequest);
}
