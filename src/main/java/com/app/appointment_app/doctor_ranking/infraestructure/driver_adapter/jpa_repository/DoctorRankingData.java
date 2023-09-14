package com.app.appointment_app.doctor_ranking.infraestructure.driver_adapter.jpa_repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class DoctorRankingData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoctorRanking;
    private String commentary;
    private double rating;

    @Override
    public String toString() {
        return "DoctorRankingData{" +
                "idDoctorRanking=" + idDoctorRanking +
                ", commentary='" + commentary + '\'' +
                ", rating=" + rating +
                '}';
    }

    public DoctorRankingData(Long idDoctorRanking, String commentary, double rating) {
        this.idDoctorRanking = idDoctorRanking;
        this.commentary = commentary;
        this.rating = rating;
    }

    public DoctorRankingData() {
    }

    public Long getIdDoctorRanking() {
        return idDoctorRanking;
    }

    public void setIdDoctorRanking(Long idDoctorRanking) {
        this.idDoctorRanking = idDoctorRanking;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
