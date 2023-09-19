package com.app.appointmentapp.appointment.domain.usecases.cruds;

import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointmentapp.appointment.domain.model.Appointment;

public class AppointmentFindByIdUseCase {
    private final AppointmentFindByIdGetway appointmentFindByIdGetway;

    public AppointmentFindByIdUseCase(AppointmentFindByIdGetway appointmentFindByIdGetway) {
        this.appointmentFindByIdGetway = appointmentFindByIdGetway;
    }

    public Appointment findAppointmentById(Long id) {
        return appointmentFindByIdGetway.findById((id));
    }
}
