package com.app.appointmentapp.patient.domain.getways.business_services;
import com.app.appointmentapp.patient.domain.requests.CancelReschedulingRequest;
import com.app.appointmentapp.patient.domain.responses.CancelReschedulingResponse;

public interface CancelReschedulingGetway {
    CancelReschedulingResponse cancelRescheduling(CancelReschedulingRequest cancelReschedulingRequest);
}
