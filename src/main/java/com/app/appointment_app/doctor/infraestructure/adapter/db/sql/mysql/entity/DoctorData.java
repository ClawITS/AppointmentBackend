package com.app.appointment_app.doctor.infraestructure.adapter.db.sql.mysql.entity;

import com.app.appointment_app.disponibility.infraestructure.adapter.db.sql.mysql.entity.DisponibilityData;
import com.app.appointment_app.speciality.infraestructure.adapter.db.sql.mysql.entity.SpecialityData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
@Entity(name = "doctors")
public class DoctorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoctor;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy ="doctor", cascade = CascadeType.ALL)
    private List<DisponibilityData> disponibilityList;
    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private SpecialityData speciality;

    @Override
    public String toString() {
        return "DoctorData{" +
                "idDoctor=" + idDoctor +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", disponibilityList=" + disponibilityList +
                '}';
    }

    public DoctorData() {
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

    public List<DisponibilityData> getDisponibilityList() {
        return disponibilityList;
    }

    public void setDisponibilityList(List<DisponibilityData> disponibilityList) {
        this.disponibilityList = disponibilityList;
    }

    public SpecialityData getSpeciality() {
        return speciality;
    }

    public void setSpeciality(SpecialityData speciality) {
        this.speciality = speciality;
    }

    public DoctorData(Long idDoctor, String name, String description, List<DisponibilityData> disponibilityList) {
        this.idDoctor = idDoctor;
        this.name = name;
        this.description = description;
        this.disponibilityList = disponibilityList;
    }

    public static final class DoctorDataBuilder {
        private Long idDoctor;
        private String name;
        private String description;
        private List<DisponibilityData> disponibilityList;
        private SpecialityData speciality;

        public DoctorDataBuilder() {
        }

        public static DoctorDataBuilder aDoctorData() {
            return new DoctorDataBuilder();
        }

        public DoctorDataBuilder withIdDoctor(Long idDoctor) {
            this.idDoctor = idDoctor;
            return this;
        }

        public DoctorDataBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DoctorDataBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public DoctorDataBuilder withDisponibilityList(List<DisponibilityData> disponibilityList) {
            this.disponibilityList = disponibilityList;
            return this;
        }

        public DoctorDataBuilder withSpeciality(SpecialityData speciality) {
            this.speciality = speciality;
            return this;
        }

        public DoctorData build() {
            DoctorData doctorData = new DoctorData();
            doctorData.setIdDoctor(idDoctor);
            doctorData.setName(name);
            doctorData.setDescription(description);
            doctorData.setDisponibilityList(disponibilityList);
            doctorData.setSpeciality(speciality);
            return doctorData;
        }
    }
}
