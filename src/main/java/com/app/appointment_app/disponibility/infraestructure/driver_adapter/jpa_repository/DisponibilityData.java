package com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.disponibility.domain.model.enums.DisponibilityState;
import com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository.DoctorData;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import java.util.Date;

@Entity(name = "disponibilities")
public class DisponibilityData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisponibility;
    @JsonDeserialize
    private Date hour;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorData doctor;
    @Enumerated(EnumType.STRING)
    private DisponibilityState disponibilityState;

    @Override
    public String toString() {
        return "DisponibilityData{" +
                "idDisponibility=" + idDisponibility +
                ", hour=" + hour +
                ", doctor=" + doctor +
                ", disponibilityState=" + disponibilityState +
                '}';
    }

    public Long getIdDisponibility() {
        return idDisponibility;
    }

    public void setIdDisponibility(Long idDisponibility) {
        this.idDisponibility = idDisponibility;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public DoctorData getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorData doctor) {
        this.doctor = doctor;
    }

    public DisponibilityState getDisponibilityState() {
        return disponibilityState;
    }

    public void setDisponibilityState(DisponibilityState disponibilityState) {
        this.disponibilityState = disponibilityState;
    }

    public DisponibilityData() {
    }

    public DisponibilityData(Long idDisponibility, Date hour, DoctorData doctor, DisponibilityState disponibilityState) {
        this.idDisponibility = idDisponibility;
        this.hour = hour;
        this.doctor = doctor;
        this.disponibilityState = disponibilityState;
    }
}
