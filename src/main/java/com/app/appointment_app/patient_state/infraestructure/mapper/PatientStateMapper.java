package com.app.appointment_app.patient_state.infraestructure.mapper;

import com.app.appointment_app.patient_state.domain.model.PatientState;
import com.app.appointment_app.patient_state.infraestructure.driver_adapter.jpa_repository.PatientStateData;
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
