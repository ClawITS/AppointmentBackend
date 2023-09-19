package com.app.appointment_app.disponibility.domain.responses;

import java.util.Date;

public class DisponibilitySaveResponse {
    private Date hour;
    private String doctor;
    private DisponibilitySaveResponse(Builder builder) {
        this.hour = builder.hour;
        this.doctor = builder.doctor;
    }

    public Date getHour() {
        return hour;
    }

    public String getDoctor() {
        return doctor;
    }

    public static class Builder {
        private Date hour;
        private String doctor;

        public Builder hour(Date hour) {
            this.hour = hour;
            return this;
        }

        public Builder doctor(String doctor) {
            this.doctor = doctor;
            return this;
        }

        public DisponibilitySaveResponse build() {
            return new DisponibilitySaveResponse(this);
        }

}
}
