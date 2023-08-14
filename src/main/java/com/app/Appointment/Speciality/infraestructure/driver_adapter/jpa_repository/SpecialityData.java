package com.app.Appointment.Speciality.infraestructure.driver_adapter.jpa_repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "speciality")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecialityData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpeciality;
    private String name;
    private Integer grade;
}
