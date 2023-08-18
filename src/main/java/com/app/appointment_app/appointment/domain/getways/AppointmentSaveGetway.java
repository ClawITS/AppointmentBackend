package com.app.appointment_app.appointment.domain.getways;

import com.app.appointment_app.appointment.domain.model.Appointment;

public interface AppointmentSaveGetway {
    Appointment save(Appointment appointment);
}
