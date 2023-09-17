package com.app.appointment_app.doctor.infraestructure.entry_point;

import com.app.appointment_app.commons.infraestructure.rest.dto.response.CustomResponse;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.domain.requests.AcceptPatientReschedulingRequest;
import com.app.appointment_app.doctor.domain.requests.RescheduleAppointmentRequest;
import com.app.appointment_app.doctor.domain.responses.AcceptPatientReschedulingResponse;
import com.app.appointment_app.doctor.domain.responses.RescheduleAppointmentResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.app.appointment_app.commons.infraestructure.rest.entry_points.constants.GlobalApiConstant.*;
import static com.app.appointment_app.doctor.infraestructure.entry_point.constants.DoctorApiConstants.ACCEPT_RESCHEDULE_APPOINTMENT;
import static com.app.appointment_app.doctor.infraestructure.entry_point.constants.DoctorApiConstants.RESCHEDULE_APPOINTMENT;

public interface IDoctorController {
    @PostMapping
    ResponseEntity<CustomResponse> saveDoctor(@RequestBody Doctor doctor);

    @DeleteMapping(ID_PARAM)
    ResponseEntity<String> deleteDoctorById(@PathVariable Long id);

    @GetMapping(ID_PARAM)
    ResponseEntity<Doctor> findDoctorById(@PathVariable Long id);

    @GetMapping(GENERIC_PAGINATOR_PARAM)
    ResponseEntity<Page<Doctor>> findAllPageDoctors(@PathVariable int numberPage);

    @PostMapping(RESCHEDULE_APPOINTMENT)
    ResponseEntity<RescheduleAppointmentResponse> rescheduleAppointment(@RequestBody RescheduleAppointmentRequest
                                                                                rescheduleAppointmentRequest);

    @PostMapping(ACCEPT_RESCHEDULE_APPOINTMENT)
    ResponseEntity<AcceptPatientReschedulingResponse> acceptReschedule(@RequestBody AcceptPatientReschedulingRequest acceptPatientReschedulingRequest);
}
