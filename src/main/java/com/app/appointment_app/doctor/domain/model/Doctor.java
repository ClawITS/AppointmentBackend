package com.app.appointment_app.doctor.domain.model;


import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.doctor_ranking.domain.model.DoctorRanking;

import java.util.List;

public class Doctor {
    private Long idDoctor;
    private String name;
    private String description;
    private List<Disponibility> disponibilityList;

    private DoctorRanking doctorRanking;

    @Override
    public String toString() {
        return "Doctor{" +
                "idDoctor=" + idDoctor +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", disponibilityList=" + disponibilityList +
                ", doctorRanking=" + doctorRanking +
                '}';
    }

    public Doctor() {
    }

    public Doctor(Long idDoctor, String name, String description, List<Disponibility> disponibilityList, DoctorRanking doctorRanking) {
        this.idDoctor = idDoctor;
        this.name = name;
        this.description = description;
        this.disponibilityList = disponibilityList;
        this.doctorRanking = doctorRanking;
    }

    public DoctorRanking getDoctorRanking() {
        return doctorRanking;
    }

    public void setDoctorRanking(DoctorRanking doctorRanking) {
        this.doctorRanking = doctorRanking;
    }

    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Disponibility> getDisponibilityList() {
        return disponibilityList;
    }

    public void setDisponibilityList(List<Disponibility> disponibilityList) {
        this.disponibilityList = disponibilityList;
    }

}
