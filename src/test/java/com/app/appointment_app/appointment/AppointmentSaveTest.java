package com.app.appointment_app.appointment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.appointment.domain.usecases.AppointmentSaveUseCase;
import com.app.appointment_app.appointment.infraestructure.entry_point.AppointmentController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class AppointmentSaveTest {
    @Mock
    private AppointmentSaveUseCase appointmentSaveUseCase;
    @InjectMocks
    private AppointmentController appointmentController;

    @Test
    void testSaveAppointment() {
        Appointment appointment = new Appointment();
        appointment.setIdAppointment(1L);
        appointment.setState(State.EARRING);
        when(appointmentSaveUseCase.saveAppointment(appointment)).thenReturn(appointment);

        ResponseEntity<Appointment> response = appointmentController.save(appointment);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(appointment, response.getBody());

        verify(appointmentSaveUseCase, times(1)).saveAppointment(appointment);
    }
}
