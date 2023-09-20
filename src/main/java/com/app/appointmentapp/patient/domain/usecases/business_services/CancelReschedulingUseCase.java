package com.app.appointmentapp.patient.domain.usecases.business_services;

import com.app.appointmentapp.appointment.domain.model.enums.State;
import com.app.appointmentapp.patient.domain.getways.business_services.CancelReschedulingGetway;
import com.app.appointmentapp.patient.domain.requests.CancelReschedulingRequest;
import com.app.appointmentapp.patient.domain.responses.CancelReschedulingResponse;
import com.app.appointmentapp.patient.domain.usecases.helpers.CancelReschedulingHelper;

public class CancelReschedulingUseCase {
    private final CancelReschedulingGetway cancelReschedulingGetway;
    private final CancelReschedulingHelper cancelReschedulingHelper;

    public CancelReschedulingUseCase(CancelReschedulingGetway cancelReschedulingGetway, CancelReschedulingHelper cancelReschedulingHelper) {
        this.cancelReschedulingGetway = cancelReschedulingGetway;
        this.cancelReschedulingHelper = cancelReschedulingHelper;
    }
    public CancelReschedulingResponse cancelRescheduling(CancelReschedulingRequest cancelReschedulingRequest){
        cancelReschedulingRequest.setState(State.CANCELED);
        cancelReschedulingHelper.cancelRescheduling(cancelReschedulingRequest);
        return cancelReschedulingGetway.cancelRescheduling(cancelReschedulingRequest);
    }
}
