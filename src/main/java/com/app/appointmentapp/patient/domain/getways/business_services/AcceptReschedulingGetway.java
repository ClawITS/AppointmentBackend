package com.app.appointmentapp.patient.domain.getways.business_services;
import com.app.appointmentapp.patient.domain.requests.AcceptReschedulingRequest;
import com.app.appointmentapp.patient.domain.responses.AcceptReschedulingResponse;

public interface AcceptReschedulingGetway {

    AcceptReschedulingResponse acceptRescheduling(AcceptReschedulingRequest acceptReschedulingRequest);
}
