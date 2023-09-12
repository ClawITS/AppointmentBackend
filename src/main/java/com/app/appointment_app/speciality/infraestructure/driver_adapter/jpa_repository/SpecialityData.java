package com.app.appointment_app.speciality.infraestructure.driver_adapter.jpa_repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "speciality")

public class SpecialityData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpeciality;
    private String name;
    private Integer grade;

    @Override
    public String toString() {
        return "SpecialityData{" +
                "idSpeciality=" + idSpeciality +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    public SpecialityData(Long idSpeciality, String name, Integer grade) {
        this.idSpeciality = idSpeciality;
        this.name = name;
        this.grade = grade;
    }

    public SpecialityData() {
    }

    public Long getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(Long idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
