package com.app.appointmentapp.appointment.domain.usecases.business_services;

import com.app.appointmentapp.appointment.domain.getways.business_services.CloseAppointmentGetway;
import com.app.appointmentapp.appointment.domain.model.enums.State;
import com.app.appointmentapp.appointment.domain.dto.requests.CloseAppointmentRequest;
import com.app.appointmentapp.appointment.domain.dto.responses.CloseAppointmentResponse;
import com.app.appointmentapp.appointment.domain.usecases.helpers.CloseAppointmentHelper;

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
