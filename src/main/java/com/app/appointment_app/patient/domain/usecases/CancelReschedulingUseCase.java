package com.app.appointment_app.patient.domain.usecases;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.patient.domain.getways.CancelReschedulingGetway;

public class CancelReschedulingUseCase {
    private final CancelReschedulingGetway cancelReschedulingGetway;

    public CancelReschedulingUseCase(CancelReschedulingGetway cancelReschedulingGetway) {
        this.cancelReschedulingGetway = cancelReschedulingGetway;
    }
    public Appointment cancelRescheduling(Appointment appointment){
        appointment.setState(State.CANCELED);
        return cancelReschedulingGetway.cancelRescheduling(appointment);
    }
}
