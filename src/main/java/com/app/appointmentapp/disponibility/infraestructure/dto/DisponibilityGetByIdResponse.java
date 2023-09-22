package com.app.appointmentapp.disponibility.infraestructure.dto;

import java.util.Date;

public class DisponibilityGetByIdResponse {
    private Long idDisponibility;
    private Date hour;
    private DoctorDisponibilityResponse doctor;

    public Long getIdDisponibility() {
        return idDisponibility;
    }

    public void setIdDisponibility(Long idDisponibility) {
        this.idDisponibility = idDisponibility;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public DoctorDisponibilityResponse getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDisponibilityResponse doctor) {
        this.doctor = doctor;
    }

    public static final class DisponibilityGetByIdResponseBuilder {
        private Long idDisponibility;
        private Date hour;
        private DoctorDisponibilityResponse doctor;

        public DisponibilityGetByIdResponseBuilder() {
        }

        public static DisponibilityGetByIdResponseBuilder aDisponibilityGetByIdResponse() {
            return new DisponibilityGetByIdResponseBuilder();
        }

        public DisponibilityGetByIdResponseBuilder idDisponibility(Long idDisponibility) {
            this.idDisponibility = idDisponibility;
            return this;
        }

        public DisponibilityGetByIdResponseBuilder hour(Date hour) {
            this.hour = hour;
            return this;
        }

        public DisponibilityGetByIdResponseBuilder doctor(DoctorDisponibilityResponse doctor) {
            this.doctor = doctor;
            return this;
        }

        public DisponibilityGetByIdResponse build() {
            DisponibilityGetByIdResponse disponibilityGetByIdResponse = new DisponibilityGetByIdResponse();
            disponibilityGetByIdResponse.setIdDisponibility(idDisponibility);
            disponibilityGetByIdResponse.setHour(hour);
            disponibilityGetByIdResponse.setDoctor(doctor);
            return disponibilityGetByIdResponse;
        }
    }
}
