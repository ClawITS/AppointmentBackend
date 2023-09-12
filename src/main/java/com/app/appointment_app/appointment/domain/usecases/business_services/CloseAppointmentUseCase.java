package com.app.appointment_app.appointment.domain.usecases.business_services;

import com.app.appointment_app.appointment.domain.getways.business_services.CloseAppointmentGetway;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.appointment.domain.ports.requests.CloseAppointmentRequest;
import com.app.appointment_app.appointment.domain.ports.responses.CloseAppointmentResponse;
import com.app.appointment_app.appointment.domain.usecases.helpers.CloseAppointmentHelper;

public class CloseAppointmentUseCase {
    private final CloseAppointmentGetway closeAppointmentGetway;
    private final CloseAppointmentHelper closeAppointmentHelper;

    public CloseAppointmentUseCase(CloseAppointmentGetway closeAppointmentGetway, CloseAppointmentHelper closeAppointmentHelper) {
        this.closeAppointmentGetway = closeAppointmentGetway;
        this.closeAppointmentHelper = closeAppointmentHelper;
    }


    public CloseAppointmentResponse closeAppointment(CloseAppointmentRequest closeAppointmentRequest){
        closeAppointmentRequest.setState(State.ATTENDED);
        closeAppointmentHelper.attendAppointment(closeAppointmentRequest);
        return closeAppointmentGetway.closeAppointment(closeAppointmentRequest);
    }
}
