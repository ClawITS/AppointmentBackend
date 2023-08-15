package com.app.appointment_app.patient_state.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientState {
    private Long idPatientState;
    private String description;
}
