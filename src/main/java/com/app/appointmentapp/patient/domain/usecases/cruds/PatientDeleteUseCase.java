package com.app.appointmentapp.patient.domain.usecases.cruds;

import com.app.appointmentapp.patient.domain.getways.cruds.PatientDeleteGetway;

public class PatientDeleteUseCase {
    private final PatientDeleteGetway patientDeleteGetway;

    public PatientDeleteUseCase(PatientDeleteGetway patientDeleteGetway) {
        this.patientDeleteGetway = patientDeleteGetway;
    }

    public void deletePatientById(Long id) {
        patientDeleteGetway.deleteById(id);
    }
}


