package com.app.appointment_app.patient.domain.usecases;

import com.app.appointment_app.patient.domain.getways.PatientFindByIdGetway;
import com.app.appointment_app.patient.domain.model.Patient;

public class PatientFindByIdUseCase {
    private final PatientFindByIdGetway patientFindByIdGetway;

    public PatientFindByIdUseCase(PatientFindByIdGetway patientFindByIdGetway) {
        this.patientFindByIdGetway = patientFindByIdGetway;
    }

    public Patient findpatientById(Long id){
        return patientFindByIdGetway.findById(id);
    }
}
