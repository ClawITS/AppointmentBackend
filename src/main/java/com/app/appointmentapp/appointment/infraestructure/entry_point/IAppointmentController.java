package com.app.appointmentapp.appointment.infraestructure.entry_point;

import com.app.appointmentapp.appointment.domain.dto.requests.CloseAppointmentRequest;
import com.app.appointmentapp.appointment.domain.dto.responses.AppointmentPaginatorResponse;
import com.app.appointmentapp.appointment.domain.dto.responses.CloseAppointmentResponse;
import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.commons.infraestructure.rest.dto.response.CustomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.appointmentapp.appointment.infraestructure.entry_point.constants.AppointmentApiConstant.CLOSE_APPOINTMENT;
import static com.app.appointmentapp.commons.infraestructure.rest.entry_points.constants.GlobalApiConstant.GENERIC_PAGINATOR_PARAM;
import static com.app.appointmentapp.commons.infraestructure.rest.entry_points.constants.GlobalApiConstant.ID_PARAM;

public interface IAppointmentController {
    @GetMapping(ID_PARAM)
    ResponseEntity<CustomResponse> findById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<CustomResponse> save(@RequestBody Appointment appointment, BindingResult bindingResult);

    @PostMapping(CLOSE_APPOINTMENT)
    ResponseEntity<CloseAppointmentResponse> closeAppointment(@RequestBody CloseAppointmentRequest closeAppointmentRequest);

    @GetMapping(GENERIC_PAGINATOR_PARAM)
    ResponseEntity<List<AppointmentPaginatorResponse>> getAppointmentPage(@PathVariable int numberPage);

    @DeleteMapping(ID_PARAM)
    ResponseEntity<String> deleteAppointmentById(@PathVariable Long id);
}
