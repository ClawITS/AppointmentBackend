package com.app.appointment_app.appointment.domain.usecases;

import com.app.appointment_app.appointment.domain.getways.CloseAppointmentGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;

public class CloseAppointmentUseCase {
    private final CloseAppointmentGetway closeAppointmentGetway;

    public CloseAppointmentUseCase(CloseAppointmentGetway closeAppointmentGetway) {
        this.closeAppointmentGetway = closeAppointmentGetway;
    }
    public Appointment closeAppointment(Appointment appointment){
        appointment.setState(State.ATTENDED);
        return closeAppointmentGetway.closeAppointment(appointment);
    }
}
