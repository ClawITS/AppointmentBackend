package com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
@Entity(name = "doctors")
public class DoctorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoctor;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy ="doctor", cascade = CascadeType.ALL)
    private List<DisponibilityData> disponibilityList;

    @Override
    public String toString() {
        return "DoctorData{" +
                "idDoctor=" + idDoctor +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", disponibilityList=" + disponibilityList +
                '}';
    }

    public DoctorData() {
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

    public List<DisponibilityData> getDisponibilityList() {
        return disponibilityList;
    }

    public void setDisponibilityList(List<DisponibilityData> disponibilityList) {
        this.disponibilityList = disponibilityList;
    }

    public DoctorData(Long idDoctor, String name, String description, List<DisponibilityData> disponibilityList) {
        this.idDoctor = idDoctor;
        this.name = name;
        this.description = description;
        this.disponibilityList = disponibilityList;
    }
}
