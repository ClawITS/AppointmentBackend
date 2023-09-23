package com.app.appointmentapp.patient.infraestructure.entry_point;

import com.app.appointmentapp.commons.infraestructure.rest.dto.response.CustomResponse;
import com.app.appointmentapp.patient.domain.exceptions.PatientException;
import com.app.appointmentapp.patient.domain.model.Patient;
import com.app.appointmentapp.patient.domain.requests.AcceptReschedulingRequest;
import com.app.appointmentapp.patient.domain.requests.CancelReschedulingRequest;
import com.app.appointmentapp.patient.domain.requests.PatientFilterByNameRequest;
import com.app.appointmentapp.patient.domain.requests.PatientRescheduleRequest;
import com.app.appointmentapp.patient.domain.responses.AcceptReschedulingResponse;
import com.app.appointmentapp.patient.domain.responses.CancelReschedulingResponse;
import com.app.appointmentapp.patient.domain.responses.PatientRescheduleResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IPatientController {
    @GetMapping("/{id}")
    ResponseEntity<CustomResponse> findById(@PathVariable Long id) throws PatientException;

    @PostMapping
    ResponseEntity<CustomResponse> save(@RequestBody Patient patient, BindingResult bindingResult);

    @PostMapping("/acceptRescheduling")
    ResponseEntity<CustomResponse> acceptRescheduling(@RequestBody AcceptReschedulingRequest acceptReschedulingRequest,
                                                                  BindingResult bindingResult);

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
