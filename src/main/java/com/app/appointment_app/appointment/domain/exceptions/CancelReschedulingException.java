package com.app.appointment_app.appointment.domain.exceptions;
import com.app.appointment_app.appointment.domain.constants.ReschedulingMessages;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.patient.domain.requests.CancelReschedulingRequest;

public class CancelReschedulingException {
    public static void cancelReschedulingException(CancelReschedulingRequest cancelReschedulingRequest) throws AppointmentException {
        if(!cancelReschedulingRequest.getState().equals(State.EARRING)){
            throw new AppointmentException(ReschedulingMessages.INVALID_STATE);
        }
    }
}
