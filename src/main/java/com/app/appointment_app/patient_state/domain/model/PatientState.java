package com.app.appointment_app.patient_state.domain.model;


public class PatientState {
    private Long idPatientState;
    private String description;

    @Override
    public String toString() {
        return "PatientState{" +
                "idPatientState=" + idPatientState +
                ", description='" + description + '\'' +
                '}';
    }

    public PatientState(Long idPatientState, String description) {
        this.idPatientState = idPatientState;
        this.description = description;
    }

    public PatientState() {
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
