package com.app.appointment_app.appointment.domain.usecases;

import com.app.appointment_app.appointment.domain.getways.AppointmentFindAllGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import org.springframework.data.domain.Page;

import java.util.List;

public class AppointmentFindAllUseCase {
    private final AppointmentFindAllGetway appointmentFindAllGetway;

    public AppointmentFindAllUseCase(AppointmentFindAllGetway appointmentFindAllGetway) {
        this.appointmentFindAllGetway = appointmentFindAllGetway;
    }

    public Page<Appointment> findAllAppointmentPaginator(int numberPage) {
        return appointmentFindAllGetway.findAllPaginator(numberPage);
    }

    public List<Appointment> findAll() {
        return appointmentFindAllGetway.findAll();
    }
}
