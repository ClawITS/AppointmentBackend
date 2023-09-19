package com.app.appointment_app.doctor.domain.exceptions;

import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.doctor.domain.constants.DoctorExceptionMessages;
import com.app.appointment_app.doctor.domain.dto.requests.AcceptPatientReschedulingRequest;

public class AcceptPatientRescheduleException {
    public static void invalidState(AcceptPatientReschedulingRequest acceptPatientReschedulingRequest)
    throws DoctorException{
        if(!acceptPatientReschedulingRequest.getState().equals(State.EARRINGBYDOCTOR)){
            throw new DoctorException(DoctorExceptionMessages.INVALID_ACCEPT_PATIENT_RESCHEDULE_STATE
            + acceptPatientReschedulingRequest.getState());
        }
    }
}
