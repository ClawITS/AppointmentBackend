package com.app.appointment_app.patient.domain.getways;
import com.app.appointment_app.patient.domain.requests.CancelReschedulingRequest;
import com.app.appointment_app.patient.domain.responses.CancelReschedulingResponse;

public interface CancelReschedulingGetway {
    CancelReschedulingResponse cancelRescheduling(CancelReschedulingRequest cancelReschedulingRequest);
}
