package com.app.appointmentapp.patient.domain.usecases.cruds;

import com.app.appointmentapp.patient.domain.exceptions.PatientException;
import com.app.appointmentapp.patient.domain.getways.cruds.PatientFindByIdGetway;
import com.app.appointmentapp.patient.domain.model.Patient;

import static com.app.appointmentapp.patient.domain.constants.PatientExceptionConstants.PATIENT_NOT_FOUND;
import static java.util.Objects.isNull;

public class PatientFindByIdUseCase {
    private final PatientFindByIdGetway patientFindByIdGetway;

    public PatientFindByIdUseCase(PatientFindByIdGetway patientFindByIdGetway) {
        this.patientFindByIdGetway = patientFindByIdGetway;
    }

    public Patient findPatientById(Long id) throws PatientException {
        Patient patient =patientFindByIdGetway.findById(id);
        if(isNull(patient)){
            throw new PatientException(PATIENT_NOT_FOUND);
        }
        return patient;
    }
}
