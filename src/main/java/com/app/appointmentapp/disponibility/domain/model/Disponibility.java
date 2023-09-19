package com.app.appointmentapp.disponibility.domain.model;

import com.app.appointmentapp.disponibility.domain.model.enums.DisponibilityState;
import com.app.appointmentapp.doctor.domain.model.Doctor;

import java.util.Date;

public class Disponibility {
    private Long idDisponibility;
    private Date hour;
    private Doctor doctor;
    private DisponibilityState disponibilityState;

    public Disponibility() {
    }

    @Override
    public String toString() {
        return "Disponibility{" +
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public DisponibilityState getDisponibilityState() {
        return disponibilityState;
    }

    public void setDisponibilityState(DisponibilityState disponibilityState) {
        this.disponibilityState = disponibilityState;
    }

    public Disponibility(Long idDisponibility, Date hour, Doctor doctor, DisponibilityState disponibilityState) {
        this.idDisponibility = idDisponibility;
        this.hour = hour;
        this.doctor = doctor;
        this.disponibilityState = disponibilityState;
    }
}
