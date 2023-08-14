package com.app.Appointment.PatientState.infraestructure.mapper;

import com.app.Appointment.PatientState.domain.model.PatientState;
import com.app.Appointment.PatientState.infraestructure.driver_adapter.jpa_repository.PatientStateData;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class PatientStateMapper {
    public PatientState toPatientState(PatientStateData patientStateData){
        return new PatientState(patientStateData.getIdPatientState(),
                patientStateData.getDescription());
    }
    public PatientStateData toData(PatientState patientState){
        return new PatientStateData(patientState.getIdPatientState(),
                patientState.getDescription());
    }
}
