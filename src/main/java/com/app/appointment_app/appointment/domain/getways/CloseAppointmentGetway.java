package com.app.appointment_app.appointment.domain.getways;

import com.app.appointment_app.appointment.domain.model.Appointment;

public interface CloseAppointmentGetway {
    Appointment closeAppointment(Appointment appointment);
}
