package com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
