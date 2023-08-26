package com.app.appointment_app.appointment.domain.exceptions;

import com.app.appointment_app.appointment.domain.constants.CloseAppointmentMessages;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;

public class CloseAppointmentException {

    public static void stateException(Appointment appointment) throws AppointmentException {
        if(appointment.getState()!=State.OPEN && appointment.getState()!=State.RESCHEDULED) {
            throw new AppointmentException(CloseAppointmentMessages.CLOSE_APPOINTMENT_INCORRECT_STATE
                    + appointment.getState());
        }

    }
}
