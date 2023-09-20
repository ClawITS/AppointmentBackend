package com.app.appointmentapp.patient.domain.getways.cruds;

import com.app.appointmentapp.patient.domain.model.Patient;

public interface PatientSaveGetway {
    Patient save(Patient patient);
}
