package com.app.appointment_app.patient.domain.usecases;

import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.patient.domain.getways.CancelReschedulingGetway;
import com.app.appointment_app.patient.domain.requests.CancelReschedulingRequest;
import com.app.appointment_app.patient.domain.responses.CancelReschedulingResponse;
import com.app.appointment_app.patient.domain.usecases.helpers.CancelReschedulingHelper;

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
