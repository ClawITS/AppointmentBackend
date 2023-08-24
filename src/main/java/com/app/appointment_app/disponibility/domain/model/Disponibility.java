package com.app.appointment_app.disponibility.domain.model;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.doctor.domain.model.Doctor;

import java.util.Date;

public class Disponibility {
    private Long idDisponibility;
    private Date hour;
    private Doctor doctor;

    public Disponibility(Long idDisponibility, Date hour, Doctor doctor) {
        this.idDisponibility = idDisponibility;
        this.hour = hour;
        this.doctor = doctor;
    }

    public Disponibility() {
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

    @Override
    public String toString() {
        return "Disponibility{" +
                "idDisponibility=" + idDisponibility +
                ", hour=" + hour +
                ", doctor=" + doctor +
                '}';
    }
}
