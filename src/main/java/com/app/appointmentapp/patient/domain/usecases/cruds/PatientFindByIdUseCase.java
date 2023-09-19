package com.app.appointmentapp.patient.domain.usecases.cruds;

import com.app.appointmentapp.patient.domain.getways.cruds.PatientFindByIdGetway;
import com.app.appointmentapp.patient.domain.model.Patient;

public class PatientFindByIdUseCase {
    private final PatientFindByIdGetway patientFindByIdGetway;

    public PatientFindByIdUseCase(PatientFindByIdGetway patientFindByIdGetway) {
        this.patientFindByIdGetway = patientFindByIdGetway;
    }

    public Patient findPatientById(Long id){
        return patientFindByIdGetway.findById(id);
    }
}
