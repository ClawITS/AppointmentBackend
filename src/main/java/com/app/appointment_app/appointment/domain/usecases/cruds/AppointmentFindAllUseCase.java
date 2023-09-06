package com.app.appointment_app.appointment.domain.usecases.cruds;

import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentFindAllGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.responses.AppointmentPaginatorResponse;

import java.util.List;

public class AppointmentFindAllUseCase {
    private final AppointmentFindAllGetway appointmentFindAllGetway;

    public AppointmentFindAllUseCase(AppointmentFindAllGetway appointmentFindAllGetway) {
        this.appointmentFindAllGetway = appointmentFindAllGetway;
    }

    public List<AppointmentPaginatorResponse> findAllAppointmentPaginator(int numberPage) {
        return appointmentFindAllGetway.findAllPaginator(numberPage);
    }

    public List<Appointment> findAll() {
        return appointmentFindAllGetway.findAll();
    }
}
