package com.app.appointment_app.patient_state.infraestructure.driver_adapter.jpa_repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "patientStates")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientStateData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatientState;
    private String description;
}
