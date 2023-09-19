package com.app.appointmentapp.doctor.domain.dto.response;

import com.app.appointmentapp.speciality.domain.model.Speciality;

import java.util.List;

public class DoctorResponse {
    private String name;
    private String description;
    private List<DoctorDisponibilityListResponse> newDisponibilitiesHour;
    private Speciality speciality;

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

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public static final class DoctorResponseBuilder {
        private String name;
        private String description;
        private List<DoctorDisponibilityListResponse> newDisponibilitiesHour;
        private Speciality speciality;

        public DoctorResponseBuilder() {
            // TODO document why this constructor is empty
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

        public DoctorResponseBuilder withSpeciality(Speciality speciality) {
            this.speciality = speciality;
            return this;
        }

        public DoctorResponse build() {
            DoctorResponse doctorResponse = new DoctorResponse();
            doctorResponse.setName(name);
            doctorResponse.setDescription(description);
            doctorResponse.setNewDisponibilitiesHour(newDisponibilitiesHour);
            doctorResponse.setSpeciality(speciality);
            return doctorResponse;
        }
    }
}
