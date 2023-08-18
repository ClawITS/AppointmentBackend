package com.app.appointment_app.appointment.domain.usecases;

import com.app.appointment_app.appointment.domain.getways.AppointmentSaveGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;

public class AppointmentSaveUseCase {
    private final AppointmentSaveGetway appointmentSaveGetway;

    public AppointmentSaveUseCase(AppointmentSaveGetway appointmentSaveGetway) {
        this.appointmentSaveGetway = appointmentSaveGetway;
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentSaveGetway.save(appointment);
    }
}
