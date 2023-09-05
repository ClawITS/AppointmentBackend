package com.app.appointment_app.patient.domain.usecases.cruds;

import com.app.appointment_app.patient.domain.getways.cruds.PatientDeleteGetway;

public class PatientDeleteUseCase {
    private final PatientDeleteGetway patientDeleteGetway;

    public PatientDeleteUseCase(PatientDeleteGetway patientDeleteGetway) {
        this.patientDeleteGetway = patientDeleteGetway;
    }

    public void deletePatientById(Long id) {
        patientDeleteGetway.deleteById(id);
    }
}


