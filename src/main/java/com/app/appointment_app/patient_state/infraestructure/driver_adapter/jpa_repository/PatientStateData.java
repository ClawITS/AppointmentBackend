package com.app.appointment_app.patient_state.infraestructure.driver_adapter.jpa_repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity(name = "patientStates")

public class PatientStateData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatientState;
    private String description;

    @Override
    public String toString() {
        return "PatientStateData{" +
                "idPatientState=" + idPatientState +
                ", description='" + description + '\'' +
                '}';
    }

    public PatientStateData(Long idPatientState, String description) {
        this.idPatientState = idPatientState;
        this.description = description;
    }

    public PatientStateData() {
    }

    public Long getIdPatientState() {
        return idPatientState;
    }

    public void setIdPatientState(Long idPatientState) {
        this.idPatientState = idPatientState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
