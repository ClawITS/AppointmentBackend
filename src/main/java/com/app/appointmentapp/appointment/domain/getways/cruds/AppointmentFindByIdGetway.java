package com.app.appointmentapp.appointment.domain.getways.cruds;

import com.app.appointmentapp.appointment.domain.model.Appointment;
public interface AppointmentFindByIdGetway {
    Appointment findById(Long id);
}
