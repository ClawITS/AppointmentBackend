package com.app.appointment_app.doctor_ranking.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository.DoctorData;
import jakarta.persistence.*;


@Entity(name = "doctor_ranking")
public class DoctorRankingData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoctorRanking;
    private String commentary;
    private double rating;
    @OneToOne
    @JoinColumn(name="doctor_id")
    private DoctorData doctor;


    @Override
    public String toString() {
        return "DoctorRankingData{" +
                "idDoctorRanking=" + idDoctorRanking +
                ", commentary='" + commentary + '\'' +
                ", rating=" + rating + '\'' +
                ", doctor=" + doctor +
                '}';
    }

    public DoctorRankingData(Long idDoctorRanking, String commentary, double rating, DoctorData doctor) {
        this.idDoctorRanking = idDoctorRanking;
        this.commentary = commentary;
        this.rating = rating;
        this.doctor = doctor;
    }

    public DoctorData getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorData doctor) {
        this.doctor = doctor;
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
