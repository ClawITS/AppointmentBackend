package com.app.appointment_app.patient.domain.getways;

import com.app.appointment_app.appointment.domain.model.Appointment;

public interface CancelReschedulingGetway {
    Appointment cancelRescheduling(Appointment appointment);
}
