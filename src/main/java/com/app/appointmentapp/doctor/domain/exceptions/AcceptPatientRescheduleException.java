package com.app.appointmentapp.doctor.domain.exceptions;

import com.app.appointmentapp.appointment.domain.model.enums.State;
import com.app.appointmentapp.doctor.domain.constants.DoctorExceptionMessages;
import com.app.appointmentapp.doctor.domain.dto.requests.AcceptPatientReschedulingRequest;

public class AcceptPatientRescheduleException {
    private AcceptPatientRescheduleException() {
    }

    public static void invalidState(AcceptPatientReschedulingRequest acceptPatientReschedulingRequest)
    throws DoctorException{
        if(!acceptPatientReschedulingRequest.getState().equals(State.EARRINGBYDOCTOR)){
            throw new DoctorException(DoctorExceptionMessages.INVALID_ACCEPT_PATIENT_RESCHEDULE_STATE
            + acceptPatientReschedulingRequest.getState());
        }
    }
}
