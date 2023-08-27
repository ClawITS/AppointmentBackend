package com.app.appointment_app.patient.domain.usecases;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.patient.domain.getways.AcceptReschedulingGetway;

public class AcceptReschedulingUseCase {
    private final AcceptReschedulingGetway acceptReschedulingGetway;

    public AcceptReschedulingUseCase(AcceptReschedulingGetway acceptReschedulingGetway) {
        this.acceptReschedulingGetway = acceptReschedulingGetway;
    }
    public Appointment acceptRescheduling(Appointment appointment){
        appointment.setState(State.RESCHEDULED);
        return acceptReschedulingGetway.acceptRescheduling(appointment);
    }
}
