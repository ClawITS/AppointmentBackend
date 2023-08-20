package com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "doctors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoctor;
    private String name;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy ="doctor", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<DisponibilityData> disponibilities;
}
