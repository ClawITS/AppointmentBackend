package com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.entity;

import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.disponibility.infraestructure.adapter.db.sql.mysql.entity.DisponibilityData;
import com.app.appointment_app.patient.infraestructure.adapter.db.sql.mysql.entity.PatientData;
import jakarta.persistence.*;

@Entity(name = "appointments")
public class AppointmentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAppointment;
    @OneToOne
    @JoinColumn(name = "disponibility_id")
    private DisponibilityData disponibility;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientData patient;
    private State state;

    @Override
    public String toString() {
        return "AppointmentData{" +
                "idAppointment=" + idAppointment +
                ", disponibility=" + disponibility +
                ", patient=" + patient +
                ", state=" + state +
                '}';
    }

    public AppointmentData(Long idAppointment, DisponibilityData disponibility, PatientData patientData, State state) {
        this.idAppointment = idAppointment;
        this.disponibility = disponibility;
        this.patient = patientData;
        this.state = state;
    }

    public AppointmentData() {
    }

    public DisponibilityData getDisponibility() {
        return disponibility;
    }

    public void setDisponibility(DisponibilityData disponibility) {
        this.disponibility = disponibility;
    }

    public PatientData getPatientData() {
        return patient;
    }

    public void setPatientData(PatientData patientData) {
        this.patient = patientData;
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
