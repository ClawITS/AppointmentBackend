package com.app.appointmentapp.appointment.domain.getways.cruds;

import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.appointment.domain.dto.responses.AppointmentPaginatorResponse;

import java.util.List;

public interface AppointmentFindAllGetway {
    List<AppointmentPaginatorResponse> findAllPaginator(int numberPage);

    List<Appointment> findAll();
}
