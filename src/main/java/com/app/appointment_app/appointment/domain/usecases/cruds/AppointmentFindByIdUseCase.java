package com.app.appointment_app.appointment.domain.usecases.cruds;

import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;

public class AppointmentFindByIdUseCase {
    private final AppointmentFindByIdGetway appointmentFindByIdGetway;

    public AppointmentFindByIdUseCase(AppointmentFindByIdGetway appointmentFindByIdGetway) {
        this.appointmentFindByIdGetway = appointmentFindByIdGetway;
    }

    public Appointment findAppointmentById(Long id) {
        return appointmentFindByIdGetway.findById((id));
    }
}