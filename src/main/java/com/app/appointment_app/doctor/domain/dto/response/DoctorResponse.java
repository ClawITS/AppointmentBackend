package com.app.appointment_app.doctor.domain.dto.response;

import java.util.List;

public class DoctorResponse {
    private String name;
    private String description;
    private List<DoctorDisponibilityListResponse> newDisponibilitiesHour;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DoctorDisponibilityListResponse> getNewDisponibilitiesHour() {
        return newDisponibilitiesHour;
    }

    public void setNewDisponibilitiesHour(List<DoctorDisponibilityListResponse> newDisponibilitiesHour) {
        this.newDisponibilitiesHour = newDisponibilitiesHour;
    }

    public static final class DoctorResponseBuilder {
        private String name;
        private String description;
        private List<DoctorDisponibilityListResponse> newDisponibilitiesHour;

        public DoctorResponseBuilder() {
        }

        public static DoctorResponseBuilder aDoctorResponse() {
            return new DoctorResponseBuilder();
        }

        public DoctorResponseBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DoctorResponseBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public DoctorResponseBuilder withNewDisponibilitiesHour(List<DoctorDisponibilityListResponse> newDisponibilitiesHour) {
            this.newDisponibilitiesHour = newDisponibilitiesHour;
            return this;
        }

        public DoctorResponse build() {
            DoctorResponse doctorResponse = new DoctorResponse();
            doctorResponse.setName(name);
            doctorResponse.setDescription(description);
            doctorResponse.setNewDisponibilitiesHour(newDisponibilitiesHour);
            return doctorResponse;
        }
    }
}
