package com.app.appointment_app.patient.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.patient.domain.model.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    private String name;
    private Integer document;
    private Date birthDate;
    private String email;
    private Gender gender;
}
