package com.app.Appointment.DoctorRanking.infraestructure.driver_adapter.jpa_repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRankingData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoctorRanking;
    private String commentary;
    private double rating;
}
