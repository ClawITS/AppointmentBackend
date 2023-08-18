package com.app.appointment_app.appointment;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.appointment.domain.usecases.AppointmentFindByIdUseCase;
import com.app.appointment_app.appointment.infraestructure.entry_point.AppointmentController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppointmentFindByIdTest {
    @Mock
    private AppointmentFindByIdUseCase appointmentFindByIdUseCase;
    @InjectMocks
    private AppointmentController appointmentController;

    @Test
    void testFindByIdAppointment() {
        Appointment appointment = new Appointment();
        appointment.setIdAppointment(1L);
        appointment.setState(State.EARRING);
        when(appointmentFindByIdUseCase.findAppointmentById(appointment.getIdAppointment())).thenReturn(appointment);
        ResponseEntity<Appointment> response = appointmentController.findById(appointment.getIdAppointment());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(appointment, response.getBody());
    }
}
