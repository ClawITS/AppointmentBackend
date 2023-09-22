package com.app.appointmentapp.doctor.infraestructure.entry_point.dto.response;

public class DoctorFindedResponse {
    private String name;
    private String description;
    private String speciality;

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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public static final class DoctorFindedResponseBuilder {
        private String name;
        private String description;
        private String speciality;

        public DoctorFindedResponseBuilder() {
            // TODO document why this constructor is empty
        }

        public static DoctorFindedResponseBuilder adoctorFindedResponse() {
            return new DoctorFindedResponseBuilder();
        }

        public DoctorFindedResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DoctorFindedResponseBuilder description(String description) {
            this.description = description;
            return this;
        }

        public DoctorFindedResponseBuilder speciality(String speciality) {
            this.speciality = speciality;
            return this;
        }

        public DoctorFindedResponse build() {
            DoctorFindedResponse doctorFindedResponse = new DoctorFindedResponse();
            doctorFindedResponse.setName(name);
            doctorFindedResponse.setDescription(description);
            doctorFindedResponse.setSpeciality(speciality);
            return doctorFindedResponse;
        }
    }
}
