package com.app.appointment_app.appointment.domain.getways;

import com.app.appointment_app.appointment.domain.model.Appointment;
public interface AppointmentFindByIdGetway {
    Appointment findById(Long id);
}
