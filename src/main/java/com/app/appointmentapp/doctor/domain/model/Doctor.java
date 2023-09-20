package com.app.appointmentapp.doctor.domain.model;
import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.speciality.domain.model.Speciality;

import java.util.List;

public class Doctor {
    private Long idDoctor;
    private String name;
    private String description;
    private List<Disponibility> disponibilityList;
    private Speciality speciality;
    public Doctor() {
    }

    public Doctor(Long idDoctor, String name, String description, List<Disponibility> disponibilityList) {
        this.idDoctor = idDoctor;
        this.name = name;
        this.description = description;
        this.disponibilityList = disponibilityList;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

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

    public List<Disponibility> getDisponibilityList() {
        return disponibilityList;
    }

    public void setDisponibilityList(List<Disponibility> disponibilityList) {
        this.disponibilityList = disponibilityList;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "idDoctor=" + idDoctor +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", disponibilityList=" + disponibilityList +
                '}';
    }

    public static final class DoctorBuilder {
        private Long idDoctor;
        private String name;
        private String description;
        private List<Disponibility> disponibilityList;
        private Speciality speciality;

        public DoctorBuilder() {
            // TODO document why this constructor is empty
        }

        public static DoctorBuilder aDoctor() {
            return new DoctorBuilder();
        }

        public DoctorBuilder withIdDoctor(Long idDoctor) {
            this.idDoctor = idDoctor;
            return this;
        }

        public DoctorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DoctorBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public DoctorBuilder withDisponibilityList(List<Disponibility> disponibilityList) {
            this.disponibilityList = disponibilityList;
            return this;
        }

        public DoctorBuilder withSpeciality(Speciality speciality) {
            this.speciality = speciality;
            return this;
        }

        public Doctor build() {
            Doctor doctor = new Doctor();
            doctor.setIdDoctor(idDoctor);
            doctor.setName(name);
            doctor.setDescription(description);
            doctor.setDisponibilityList(disponibilityList);
            doctor.speciality = this.speciality;
            return doctor;
        }
    }
}
