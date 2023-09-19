package com.app.appointment_app.appointment.infraestructure.entry_point;

import com.app.appointment_app.appointment.domain.dto.requests.CloseAppointmentRequest;
import com.app.appointment_app.appointment.domain.dto.responses.AppointmentPaginatorResponse;
import com.app.appointment_app.appointment.domain.dto.responses.CloseAppointmentResponse;
import com.app.appointment_app.appointment.domain.dto.responses.SaveAppointmentResponse;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.commons.infraestructure.rest.dto.response.CustomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.appointment_app.appointment.infraestructure.entry_point.constants.AppointmentApiConstant.CLOSE_APPOINTMENT;
import static com.app.appointment_app.commons.infraestructure.rest.entry_points.constants.GlobalApiConstant.GENERIC_PAGINATOR_PARAM;
import static com.app.appointment_app.commons.infraestructure.rest.entry_points.constants.GlobalApiConstant.ID_PARAM;

public interface IAppointmentController {
    @GetMapping(ID_PARAM)
    ResponseEntity<Appointment> findById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<CustomResponse> save(@RequestBody Appointment appointment);

    @PostMapping(CLOSE_APPOINTMENT)
    ResponseEntity<CloseAppointmentResponse> closeAppointment(@RequestBody CloseAppointmentRequest closeAppointmentRequest);

    @GetMapping(GENERIC_PAGINATOR_PARAM)
    ResponseEntity<List<AppointmentPaginatorResponse>> getAppointmentPage(@PathVariable int numberPage);

    @DeleteMapping(ID_PARAM)
    ResponseEntity<String> deleteAppointmentById(@PathVariable Long id);
}
