package com.app.appointment_app.appointment.domain.getways;
import com.app.appointment_app.appointment.domain.requests.CloseAppointmentRequest;
import com.app.appointment_app.appointment.domain.responses.CloseAppointmentResponse;

public interface CloseAppointmentGetway {
    CloseAppointmentResponse closeAppointment(CloseAppointmentRequest closeAppointmentRequest);
}
