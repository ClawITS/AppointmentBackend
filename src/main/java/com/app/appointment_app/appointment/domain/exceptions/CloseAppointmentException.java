package com.app.appointment_app.appointment.domain.exceptions;

import com.app.appointment_app.appointment.domain.constants.CloseAppointmentMessages;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.appointment.domain.dto.requests.CloseAppointmentRequest;

public class CloseAppointmentException {

    public static void stateException(CloseAppointmentRequest closeAppointmentRequest) throws AppointmentException {
        if(closeAppointmentRequest.getState()!=State.OPEN && closeAppointmentRequest.getState()!=State.RESCHEDULED) {
            throw new AppointmentException(CloseAppointmentMessages.CLOSE_APPOINTMENT_INCORRECT_STATE
                    + closeAppointmentRequest.getState());
        }

    }
}
