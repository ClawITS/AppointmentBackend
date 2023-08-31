package com.app.appointment_app.patient.domain.usecases;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.patient.domain.getways.PatientRescheduleGetway;

public class PatientResheduleUseCase {
    private final PatientRescheduleGetway patientRescheduleGetway;


    public PatientResheduleUseCase(PatientRescheduleGetway patientRescheduleGetway) {
        this.patientRescheduleGetway = patientRescheduleGetway;

    }
public Appointment patientReschedule(Appointment appointment){
        appointment.setState(State.EARRINGBYDOCTOR);
        return patientRescheduleGetway.patientRescheduleGetway(appointment);

}


}