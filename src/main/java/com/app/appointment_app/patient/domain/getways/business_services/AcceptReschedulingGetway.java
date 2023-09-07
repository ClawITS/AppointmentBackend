package com.app.appointment_app.patient.domain.getways.business_services;
import com.app.appointment_app.patient.domain.requests.AcceptReschedulingRequest;
import com.app.appointment_app.patient.domain.responses.AcceptReschedulingResponse;

public interface AcceptReschedulingGetway {

    AcceptReschedulingResponse acceptRescheduling(AcceptReschedulingRequest acceptReschedulingRequest);
}