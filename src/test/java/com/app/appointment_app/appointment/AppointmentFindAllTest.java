package com.app.appointment_app.appointment;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.appointment.domain.usecases.AppointmentFindAllUseCase;
import com.app.appointment_app.appointment.infraestructure.entry_point.AppointmentController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppointmentFindAllTest {
    @Mock
    private AppointmentFindAllUseCase appointmentFindAllUseCase;

    @InjectMocks
    private AppointmentController appointmentController;

    @Test
    void testFindAllAppointment() {
        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(new Appointment(1L, State.EARRING));

        Page<Appointment> appointmentPage = new PageImpl<>(appointmentList);

        when(appointmentFindAllUseCase.findAllAppointmentPaginator(0)).thenReturn(appointmentPage);

        ResponseEntity<Page<Appointment>> response = appointmentController.getAppointmentPage(0);
        verify(appointmentFindAllUseCase, times(1)).findAllAppointmentPaginator(0);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(appointmentPage, response.getBody());
    }

}
