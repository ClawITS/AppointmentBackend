package com.app.Appointment.Patient.infraestructure.mapper;

import com.app.Appointment.Patient.domain.model.Patient;
import com.app.Appointment.Patient.infraestructure.driver_adapter.jpa_repository.PatientData;
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
