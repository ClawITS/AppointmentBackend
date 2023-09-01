package com.app.appointment_app.appointment.domain.usecases;

import com.app.appointment_app.appointment.domain.getways.CloseAppointmentGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.appointment.domain.requests.CloseAppointmentRequest;
import com.app.appointment_app.appointment.domain.responses.CloseAppointmentResponse;

public class CloseAppointmentUseCase {
    private final CloseAppointmentGetway closeAppointmentGetway;

    public CloseAppointmentUseCase(CloseAppointmentGetway closeAppointmentGetway) {
        this.closeAppointmentGetway = closeAppointmentGetway;
    }
    public CloseAppointmentResponse closeAppointment(CloseAppointmentRequest closeAppointmentRequest){
        closeAppointmentRequest.setState(State.ATTENDED);
        return closeAppointmentGetway.closeAppointment(closeAppointmentRequest);
    }
}
