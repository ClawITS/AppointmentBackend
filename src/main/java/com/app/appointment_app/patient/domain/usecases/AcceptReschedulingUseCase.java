package com.app.appointment_app.patient.domain.usecases;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.patient.domain.getways.AcceptReschedulingGetway;
import com.app.appointment_app.patient.domain.requests.AcceptReschedulingRequest;
import com.app.appointment_app.patient.domain.responses.AcceptReschedulingResponse;

public class AcceptReschedulingUseCase {
    private final AcceptReschedulingGetway acceptReschedulingGetway;

    public AcceptReschedulingUseCase(AcceptReschedulingGetway acceptReschedulingGetway) {
        this.acceptReschedulingGetway = acceptReschedulingGetway;
    }
    public AcceptReschedulingResponse acceptRescheduling(AcceptReschedulingRequest acceptReschedulingRequest){
        acceptReschedulingRequest.setState(State.RESCHEDULED);
        return acceptReschedulingGetway.acceptRescheduling(acceptReschedulingRequest);
    }
}
