package com.app.appointment_app.appointment.domain.exceptions;

import com.app.appointment_app.appointment.domain.constants.ReschedulingMessages;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;

public class AcceptReschedulingException {
    public static void invalidStateToRescheduling(Appointment appointment) throws AppointmentException {
        if(!appointment.getState().equals(State.EARRING)){
            throw new AppointmentException(ReschedulingMessages.INVALID_STATE);
        }
    }
}
