package com.app.appointmentapp.patient.domain.usecases.business_services;

import com.app.appointmentapp.appointment.domain.model.enums.State;
import com.app.appointmentapp.patient.domain.getways.business_services.AcceptReschedulingGetway;
import com.app.appointmentapp.patient.domain.requests.AcceptReschedulingRequest;
import com.app.appointmentapp.patient.domain.responses.AcceptReschedulingResponse;
import com.app.appointmentapp.patient.domain.usecases.helpers.AcceptReschedulingHelper;

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
