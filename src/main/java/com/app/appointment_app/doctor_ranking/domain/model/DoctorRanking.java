package com.app.appointment_app.doctor_ranking.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRanking {
    private Long idDoctorRanking;
    private String commentary;
    private double rating;
}
