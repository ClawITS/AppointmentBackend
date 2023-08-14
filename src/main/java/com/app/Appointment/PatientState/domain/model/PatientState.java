package com.app.Appointment.PatientState.domain.model;

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
