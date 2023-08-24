package com.app.appointment_app.doctor_ranking.domain.model;

import com.app.appointment_app.doctor.domain.model.Doctor;

public class DoctorRanking {
    private Long idDoctorRanking;
    private String commentary;
    private double rating;

    private Doctor doctor;

    @Override
    public String toString() {
        return "DoctorRanking{" +
                "idDoctorRanking=" + idDoctorRanking +
                ", commentary='" + commentary + '\'' +
                ", rating=" + rating + '\'' +
                ", doctor=" + doctor +
                '}';
    }

    public DoctorRanking(long idDoctorRanking, String commentary, double rating, Doctor doctor) {
        this.idDoctorRanking = idDoctorRanking;
        this.commentary = commentary;
        this.rating = rating;
        this.doctor = doctor;
    }

    public DoctorRanking() {
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
