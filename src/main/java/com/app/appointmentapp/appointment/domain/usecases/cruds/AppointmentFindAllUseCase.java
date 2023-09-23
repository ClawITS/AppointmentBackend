package com.app.appointmentapp.appointment.domain.usecases.cruds;

import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentFindAllGetway;
import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.appointment.domain.dto.responses.AppointmentPaginatorResponse;

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