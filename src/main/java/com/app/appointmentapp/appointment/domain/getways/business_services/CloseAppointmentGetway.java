package com.app.appointmentapp.appointment.domain.getways.business_services;
import com.app.appointmentapp.appointment.domain.dto.requests.CloseAppointmentRequest;
import com.app.appointmentapp.appointment.domain.dto.responses.CloseAppointmentResponse;

public interface CloseAppointmentGetway {
    CloseAppointmentResponse closeAppointment(CloseAppointmentRequest closeAppointmentRequest);
}
