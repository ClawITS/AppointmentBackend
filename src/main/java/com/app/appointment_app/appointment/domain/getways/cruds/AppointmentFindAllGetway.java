package com.app.appointment_app.appointment.domain.getways.cruds;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.responses.AppointmentPaginatorResponse;

import java.util.List;

public interface AppointmentFindAllGetway {
    List<AppointmentPaginatorResponse> findAllPaginator(int numberPage);

    List<Appointment> findAll();
}
