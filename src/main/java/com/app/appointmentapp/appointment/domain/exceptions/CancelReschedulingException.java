package com.app.appointmentapp.appointment.domain.exceptions;
import com.app.appointmentapp.appointment.domain.constants.ReschedulingMessages;
import com.app.appointmentapp.appointment.domain.model.enums.State;
import com.app.appointmentapp.patient.domain.requests.CancelReschedulingRequest;

public class CancelReschedulingException {
    private CancelReschedulingException() {
    }

    public static void cancelReschedulingException(CancelReschedulingRequest cancelReschedulingRequest) throws AppointmentException {
        if(!cancelReschedulingRequest.getState().equals(State.EARRING)){
            throw new AppointmentException(ReschedulingMessages.INVALID_STATE);
        }
    }
}
