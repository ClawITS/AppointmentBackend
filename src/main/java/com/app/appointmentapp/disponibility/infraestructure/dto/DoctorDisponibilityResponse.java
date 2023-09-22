package com.app.appointmentapp.disponibility.infraestructure.dto;

public class DoctorDisponibilityResponse {
    private Long id;
    private String name;
    private String speciality;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final class DoctorDisponibilityResponseBuilder {
        private Long id;
        private String name;
        private String speciality;

        public DoctorDisponibilityResponseBuilder() {
        }

        public static DoctorDisponibilityResponseBuilder aDoctorDisponibilityResponse() {
            return new DoctorDisponibilityResponseBuilder();
        }

        public DoctorDisponibilityResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DoctorDisponibilityResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DoctorDisponibilityResponseBuilder speciality(String speciality) {
            this.speciality = speciality;
            return this;
        }

        public DoctorDisponibilityResponse build() {
            DoctorDisponibilityResponse doctorDisponibilityResponse = new DoctorDisponibilityResponse();
            doctorDisponibilityResponse.setId(id);
            doctorDisponibilityResponse.setName(name);
            doctorDisponibilityResponse.setSpeciality(speciality);
            return doctorDisponibilityResponse;
        }
    }
}
