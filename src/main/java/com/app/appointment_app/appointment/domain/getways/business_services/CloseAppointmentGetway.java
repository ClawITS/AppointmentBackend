package com.app.appointment_app.appointment.domain.getways.business_services;
import com.app.appointment_app.appointment.domain.requests.CloseAppointmentRequest;
import com.app.appointment_app.appointment.domain.responses.CloseAppointmentResponse;

public interface CloseAppointmentGetway {
    CloseAppointmentResponse closeAppointment(CloseAppointmentRequest closeAppointmentRequest);
}
