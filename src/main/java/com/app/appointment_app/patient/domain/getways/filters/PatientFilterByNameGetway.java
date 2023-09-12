package com.app.appointment_app.patient.domain.getways.filters;

import com.app.appointment_app.patient.domain.model.Patient;

import java.util.List;

public interface PatientFilterByNameGetway {
    List<Patient> getPatientsByName(String name);
}
