package com.app.appointmentapp.patient_state.infraestructure.mapper;

import com.app.appointmentapp.patient_state.domain.model.PatientState;
import com.app.appointmentapp.patient_state.infraestructure.driver_adapter.jpa_repository.PatientStateData;
import org.springframework.stereotype.Component;

@Component
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
