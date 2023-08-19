package com.app.appointment_app.patient.domain.usecases;

import com.app.appointment_app.patient.domain.getways.PatientSaveGetway;
import com.app.appointment_app.patient.domain.model.Patient;

public class PatientSaveUseCase {
    private final PatientSaveGetway patientSaveGetway;

    public PatientSaveUseCase(PatientSaveGetway patientSaveGetway) {
        this.patientSaveGetway = patientSaveGetway;
    }

    public Patient savePatient(Patient patient) {
        return patientSaveGetway.save(patient);
    }

}
