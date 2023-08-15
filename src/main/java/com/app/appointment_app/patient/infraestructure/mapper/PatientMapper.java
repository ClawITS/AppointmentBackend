package com.app.appointment_app.patient.infraestructure.mapper;

import com.app.appointment_app.patient.domain.model.Patient;
import com.app.appointment_app.patient.infraestructure.driver_adapter.jpa_repository.PatientData;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class PatientMapper {
    public Patient toPatient(PatientData patientData){
        return new Patient(patientData.getIdPatient(), patientData.getDocument(), patientData.getBirthDate(),
                patientData.getEmail(), patientData.getGender());
    }
    public PatientData toData(Patient patient){
        return new PatientData(patient.getIdPatient(), patient.getDocument(), patient.getBirthDate(),
                patient.getEmail(), patient.getGender());
    }
}
