package com.app.appointment_app.patient.domain.usecases;

import com.app.appointment_app.patient.domain.getways.PatientFindAllGetway;
import com.app.appointment_app.patient.domain.model.Patient;
import org.springframework.data.domain.Page;

import java.util.List;

public class PatientFindAllUseCase {
    private final PatientFindAllGetway patientFindAllGetway;

    public PatientFindAllUseCase(PatientFindAllGetway patientFindAllGetway) {
        this.patientFindAllGetway = patientFindAllGetway;
    }

    public Page<Patient> findAllPatientPaginator(int numberPage) {
        return patientFindAllGetway.findAllPaginator(numberPage);
    }

    public List<Patient> findAll() {
        return patientFindAllGetway.findAll();
    }
}