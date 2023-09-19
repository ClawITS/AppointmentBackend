package com.app.appointmentapp.doctor.domain.dto.response;

import com.app.appointmentapp.disponibility.domain.model.enums.DisponibilityState;

import java.util.Date;

public class DoctorDisponibilityListResponse {
    private Date hour;
    private DisponibilityState state;

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public DisponibilityState getState() {
        return state;
    }

    public void setState(DisponibilityState state) {
        this.state = state;
    }

    public static final class DoctorDisponibilityListResponseBuilder {
        private Date hour;
        private DisponibilityState state;

        public DoctorDisponibilityListResponseBuilder() {
        }

        public static DoctorDisponibilityListResponseBuilder aDoctorDisponibilityListResponse() {
            return new DoctorDisponibilityListResponseBuilder();
        }

        public DoctorDisponibilityListResponseBuilder hour(Date hour) {
            this.hour = hour;
            return this;
        }

        public DoctorDisponibilityListResponseBuilder state(DisponibilityState state) {
            this.state = state;
            return this;
        }

        public DoctorDisponibilityListResponse build() {
            DoctorDisponibilityListResponse doctorDisponibilityListResponse = new DoctorDisponibilityListResponse();
            doctorDisponibilityListResponse.setHour(hour);
            doctorDisponibilityListResponse.setState(state);
            return doctorDisponibilityListResponse;
        }
    }
}
