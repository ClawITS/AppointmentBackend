package com.app.appointment_app.appointment.domain.getways;

import com.app.appointment_app.appointment.domain.model.Appointment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AppointmentFindAllGetway {
    Page<Appointment> findAllPaginator(int numberPage);

    List<Appointment> findAll();
}
