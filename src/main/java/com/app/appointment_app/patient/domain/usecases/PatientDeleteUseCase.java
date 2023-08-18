package com.app.appointment_app.patient.domain.usecases;

import com.app.appointment_app.patient.domain.getways.PatientDeleteGetway;

public class PatientDeleteUseCase {
    private final PatientDeleteGetway patientDeleteGetway;

    public PatientDeleteUseCase(PatientDeleteGetway patientDeleteGetway) {
        this.patientDeleteGetway = patientDeleteGetway;
    }

    public void deletePatientById(Long id) {
            patientDeleteGetway.deleteById(id);
    }
}


