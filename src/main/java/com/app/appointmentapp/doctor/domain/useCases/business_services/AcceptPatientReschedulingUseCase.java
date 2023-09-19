package com.app.appointmentapp.doctor.domain.useCases.business_services;

import com.app.appointmentapp.appointment.domain.model.enums.State;
import com.app.appointmentapp.doctor.domain.getways.business_services.AcceptPatientReschedulingGetway;
import com.app.appointmentapp.doctor.domain.dto.requests.AcceptPatientReschedulingRequest;
import com.app.appointmentapp.doctor.domain.dto.response.AcceptPatientReschedulingResponse;
import com.app.appointmentapp.doctor.domain.useCases.helpers.AcceptPatientReschedulingHelper;

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
