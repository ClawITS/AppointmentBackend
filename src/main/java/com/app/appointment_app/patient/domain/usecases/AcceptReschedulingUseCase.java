package com.app.appointment_app.patient.domain.usecases;

import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.patient.domain.getways.AcceptReschedulingGetway;
import com.app.appointment_app.patient.domain.requests.AcceptReschedulingRequest;
import com.app.appointment_app.patient.domain.responses.AcceptReschedulingResponse;
import com.app.appointment_app.patient.domain.usecases.helpers.AcceptReschedulingHelper;

public class AcceptReschedulingUseCase {
    private final AcceptReschedulingGetway acceptReschedulingGetway;
    private final AcceptReschedulingHelper acceptReschedulingHelper;
    public AcceptReschedulingUseCase(AcceptReschedulingGetway acceptReschedulingGetway, AcceptReschedulingHelper acceptReschedulingHelper) {
        this.acceptReschedulingGetway = acceptReschedulingGetway;
        this.acceptReschedulingHelper = acceptReschedulingHelper;
    }
    public AcceptReschedulingResponse acceptRescheduling(AcceptReschedulingRequest acceptReschedulingRequest){
        acceptReschedulingRequest.setState(State.RESCHEDULED);
        acceptReschedulingHelper.acceptRescheduling(acceptReschedulingRequest);
        return acceptReschedulingGetway.acceptRescheduling(acceptReschedulingRequest);
    }
}
