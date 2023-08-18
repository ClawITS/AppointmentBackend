package com.app.appointment_app.appointment;

import com.app.appointment_app.appointment.domain.usecases.AppointmentDeleteUseCase;
import com.app.appointment_app.appointment.infraestructure.entry_point.AppointmentController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AppointmentDeleteTest {
    @Mock
    private AppointmentDeleteUseCase appointmentDeleteUseCase;

    @InjectMocks
    private AppointmentController appointmentController;

    @Test
    void testDeleteAppointmentById() {
        Long idToDelete = 1L;

        ResponseEntity<String> response = appointmentController.deleteAppointmentById(idToDelete);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("the entity with id " + idToDelete + " has been deleted", response.getBody());

        verify(appointmentDeleteUseCase, times(1)).deleteAppointmentById(idToDelete);
    }
}
