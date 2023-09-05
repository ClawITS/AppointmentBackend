package com.app.appointment_app.patient.domain.getways.cruds;

import com.app.appointment_app.patient.domain.model.Patient;

public interface PatientFindByIdGetway {
    Patient findById(Long id);
}
