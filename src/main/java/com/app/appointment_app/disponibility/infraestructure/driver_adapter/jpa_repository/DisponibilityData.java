package com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository.DoctorData;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.util.Date;

@Entity(name = "disponibilities")
public class DisponibilityData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisponibility;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date hour;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorData doctor;

    @Override
    public String toString() {
        return "DisponibilityData{" +
                "idDisponibility=" + idDisponibility +
                ", hour=" + hour +
                ", doctor=" + doctor +
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

    public DisponibilityData() {
    }

    public DisponibilityData(Long idDisponibility, Date hour, DoctorData doctor) {
        this.idDisponibility = idDisponibility;
        this.hour = hour;
        this.doctor = doctor;
    }
}
