package com.app.appointment_app.doctor.domain.model;


import com.app.appointment_app.disponibility.domain.model.Disponibility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class Doctor {
    private Long idDoctor;
    private String name;
    private String description;
    private List<Disponibility> disponibilities;

    public Doctor() {
    }

    public Doctor(Long idDoctor, String name, String description, List<Disponibility> disponibilities) {
        this.idDoctor = idDoctor;
        this.name = name;
        this.description = description;
        this.disponibilities = disponibilities;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "idDoctor=" + idDoctor +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", disponibilities=" + disponibilities +
                '}';
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

    public List<Disponibility> getDisponibilities() {
        return disponibilities;
    }

    public void setDisponibilities(List<Disponibility> disponibilities) {
        this.disponibilities = disponibilities;
    }
}
