package com.app.appointmentapp.patient.domain.getways.cruds;

import com.app.appointmentapp.patient.domain.model.Patient;

public interface PatientFindByIdGetway {
    Patient findById(Long id);
}
