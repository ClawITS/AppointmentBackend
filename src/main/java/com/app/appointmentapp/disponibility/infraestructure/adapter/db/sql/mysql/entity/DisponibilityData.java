package com.app.appointmentapp.disponibility.infraestructure.adapter.db.sql.mysql.entity;

import com.app.appointmentapp.disponibility.domain.model.enums.DisponibilityState;
import com.app.appointmentapp.doctor.infraestructure.adapter.db.sql.mysql.entity.DoctorData;
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

    public DisponibilityData() {
    }

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

    public DisponibilityData(Long idDisponibility, Date hour, DoctorData doctor, DisponibilityState disponibilityState) {
        this.idDisponibility = idDisponibility;
        this.hour = hour;
        this.doctor = doctor;
        this.disponibilityState = disponibilityState;
    }
}
