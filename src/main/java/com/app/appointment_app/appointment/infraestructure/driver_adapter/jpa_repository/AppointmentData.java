package com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import com.app.appointment_app.patient.infraestructure.driver_adapter.jpa_repository.PatientData;
import jakarta.persistence.*;

@Entity(name = "appointments")
public class AppointmentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAppointment;
    @OneToOne
    private DisponibilityData disponibilityData;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientData patientData;
    private State state;

    @Override
    public String toString() {
        return "AppointmentData{" +
                "idAppointment=" + idAppointment +
                ", state=" + state +
                '}';
    }

    public AppointmentData(Long idAppointment, DisponibilityData disponibilityData, PatientData patientData, State state) {
        this.idAppointment = idAppointment;
        this.disponibilityData = disponibilityData;
        this.patientData = patientData;
        this.state = state;
    }

    public AppointmentData() {
    }

    public DisponibilityData getDisponibilityData() {
        return disponibilityData;
    }

    public void setDisponibilityData(DisponibilityData disponibilityData) {
        this.disponibilityData = disponibilityData;
    }

    public PatientData getPatientData() {
        return patientData;
    }

    public void setPatientData(PatientData patientData) {
        this.patientData = patientData;
    }

    public Long getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(Long idAppointment) {
        this.idAppointment = idAppointment;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
