package com.app.appointment_app.appointment.domain.exceptions;

import com.app.appointment_app.appointment.domain.constants.AcceptReschedulingMessages;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;

public class AcceptReschedulingException {
    public static void invalidStateToRescheduling(Appointment appointment) throws AppointmentException {
        if(!appointment.getState().equals(State.EARRING)){
            throw new AppointmentException(AcceptReschedulingMessages.INVALID_STATE);
        }
    }
}
