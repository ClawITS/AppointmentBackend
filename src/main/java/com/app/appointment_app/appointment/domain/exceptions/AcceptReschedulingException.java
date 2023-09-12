package com.app.appointment_app.appointment.domain.exceptions;

import com.app.appointment_app.appointment.domain.constants.ReschedulingMessages;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.patient.domain.requests.AcceptReschedulingRequest;

public class AcceptReschedulingException {
    public static void invalidStateToRescheduling(AcceptReschedulingRequest acceptReschedulingRequest) throws AppointmentException {
        if(!acceptReschedulingRequest.getState().equals(State.EARRING)){
            throw new AppointmentException(ReschedulingMessages.INVALID_STATE);
        }
    }
}
