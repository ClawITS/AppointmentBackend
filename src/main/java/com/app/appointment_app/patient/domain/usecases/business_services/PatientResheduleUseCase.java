package com.app.appointment_app.patient.domain.usecases.business_services;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.patient.domain.getways.business_services.PatientRescheduleGetway;
import com.app.appointment_app.patient.domain.requests.PatientRescheduleRequest;
import com.app.appointment_app.patient.domain.responses.PatientRescheduleResponse;
import com.app.appointment_app.patient.domain.usecases.helpers.PatientRescheduleHelper;

public class PatientResheduleUseCase {
    private final PatientRescheduleGetway patientRescheduleGetway;
    private final PatientRescheduleHelper patientRescheduleHelper;

    public PatientResheduleUseCase(PatientRescheduleGetway patientRescheduleGetway, PatientRescheduleHelper patientRescheduleHelper) {
        this.patientRescheduleGetway = patientRescheduleGetway;

        this.patientRescheduleHelper = patientRescheduleHelper;
    }
        public PatientRescheduleResponse patientReschedule(PatientRescheduleRequest patientRescheduleRequest){
        patientRescheduleRequest.setState(State.EARRINGBYDOCTOR);
        Appointment appointment =patientRescheduleHelper.patientRescheduleAppointment(patientRescheduleRequest);
        return patientRescheduleGetway.patientRescheduleGetway(appointment);

}


}