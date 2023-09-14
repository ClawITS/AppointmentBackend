package com.app.appointment_app.patient.domain.getways.business_services;
import com.app.appointment_app.patient.domain.requests.CancelReschedulingRequest;
import com.app.appointment_app.patient.domain.responses.CancelReschedulingResponse;

public interface CancelReschedulingGetway {
    CancelReschedulingResponse cancelRescheduling(CancelReschedulingRequest cancelReschedulingRequest);
}
