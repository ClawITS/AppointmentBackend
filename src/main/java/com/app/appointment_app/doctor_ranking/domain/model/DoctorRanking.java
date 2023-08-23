package com.app.appointment_app.doctor_ranking.domain.model;

public class DoctorRanking {
    private Long idDoctorRanking;
    private String commentary;
    private double rating;

    @Override
    public String toString() {
        return "DoctorRanking{" +
                "idDoctorRanking=" + idDoctorRanking +
                ", commentary='" + commentary + '\'' +
                ", rating=" + rating +
                '}';
    }

    public DoctorRanking(Long idDoctorRanking, String commentary, double rating) {
        this.idDoctorRanking = idDoctorRanking;
        this.commentary = commentary;
        this.rating = rating;
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
