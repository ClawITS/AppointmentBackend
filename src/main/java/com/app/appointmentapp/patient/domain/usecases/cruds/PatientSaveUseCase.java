package com.app.appointmentapp.patient.domain.usecases.cruds;

import com.app.appointmentapp.patient.domain.getways.cruds.PatientSaveGetway;
import com.app.appointmentapp.patient.domain.model.Patient;

public class PatientSaveUseCase {
    private final PatientSaveGetway patientSaveGetway;

    public PatientSaveUseCase(PatientSaveGetway patientSaveGetway) {
        this.patientSaveGetway = patientSaveGetway;
    }

    public Patient savePatient(Patient patient) {
        return patientSaveGetway.save(patient);
    }

}
