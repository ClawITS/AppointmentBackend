package com.app.appointmentapp.appointment.domain.exceptions;

import com.app.appointmentapp.appointment.domain.constants.CloseAppointmentMessages;
import com.app.appointmentapp.appointment.domain.model.enums.State;
import com.app.appointmentapp.appointment.domain.dto.requests.CloseAppointmentRequest;

public class CloseAppointmentException {
    private CloseAppointmentException() {
    }

    public static void stateException(CloseAppointmentRequest closeAppointmentRequest) throws AppointmentException {
        if(closeAppointmentRequest.getState()!=State.OPEN && closeAppointmentRequest.getState()!=State.RESCHEDULED) {
            throw new AppointmentException(CloseAppointmentMessages.CLOSE_APPOINTMENT_INCORRECT_STATE
                    + closeAppointmentRequest.getState());
        }

    }
}
