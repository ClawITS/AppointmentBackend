package com.app.appointmentapp.appointment.domain.exceptions;

import com.app.appointmentapp.appointment.domain.constants.ReschedulingMessages;
import com.app.appointmentapp.appointment.domain.model.enums.State;
import com.app.appointmentapp.patient.domain.requests.AcceptReschedulingRequest;

public class AcceptReschedulingException {
    private AcceptReschedulingException() {
    }

    public static void invalidStateToRescheduling(AcceptReschedulingRequest acceptReschedulingRequest) throws AppointmentException {
        if(!acceptReschedulingRequest.getState().equals(State.EARRING)){
            throw new AppointmentException(ReschedulingMessages.INVALID_STATE);
        }
    }
}
