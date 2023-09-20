package com.app.appointmentapp.patient.domain.getways.filters;

import com.app.appointmentapp.patient.domain.model.Patient;

import java.util.List;

public interface PatientFilterByNameGetway {
    List<Patient> getPatientsByName(String name);
}
