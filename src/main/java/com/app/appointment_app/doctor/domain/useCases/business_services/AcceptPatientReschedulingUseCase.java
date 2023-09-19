package com.app.appointment_app.doctor.domain.useCases.business_services;

import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.doctor.domain.getways.business_services.AcceptPatientReschedulingGetway;
import com.app.appointment_app.doctor.domain.dto.requests.AcceptPatientReschedulingRequest;
import com.app.appointment_app.doctor.domain.dto.response.AcceptPatientReschedulingResponse;
import com.app.appointment_app.doctor.domain.useCases.helpers.AcceptPatientReschedulingHelper;

public class AcceptPatientReschedulingUseCase {
    private final AcceptPatientReschedulingGetway acceptPatientReschedulingGetway;
    private final AcceptPatientReschedulingHelper acceptPatientReschedulingHelper;

    public AcceptPatientReschedulingUseCase(AcceptPatientReschedulingGetway acceptPatientReschedulingGetway, AcceptPatientReschedulingHelper acceptPatientReschedulingHelper) {
        this.acceptPatientReschedulingGetway = acceptPatientReschedulingGetway;
        this.acceptPatientReschedulingHelper = acceptPatientReschedulingHelper;
    }
    public AcceptPatientReschedulingResponse acceptPatientRescheduling(AcceptPatientReschedulingRequest acceptPatientReschedulingRequest){
        acceptPatientReschedulingRequest.setState(State.RESCHEDULED);
        return acceptPatientReschedulingGetway.acceptPatientRescheduling(acceptPatientReschedulingHelper
                .acceptPatientRescheduling(acceptPatientReschedulingRequest));
    }
}
