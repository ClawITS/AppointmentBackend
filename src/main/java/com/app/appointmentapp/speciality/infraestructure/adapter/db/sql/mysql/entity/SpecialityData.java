package com.app.appointmentapp.speciality.infraestructure.adapter.db.sql.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "speciality")

public class SpecialityData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpeciality;
    private String name;
    private Integer grade;

    @Override
    public String toString() {
        return "SpecialityData{" +
                "idSpeciality=" + idSpeciality +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    public SpecialityData() {
        // TODO document why this constructor is empty
    }

    public Long getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(Long idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public static final class SpecialityDataBuilder {
        private Long idSpeciality;
        private String name;
        private Integer grade;

        public SpecialityDataBuilder() {
        }

        public static SpecialityDataBuilder aSpecialityData() {
            return new SpecialityDataBuilder();
        }

        public SpecialityDataBuilder idSpeciality(Long idSpeciality) {
            this.idSpeciality = idSpeciality;
            return this;
        }

        public SpecialityDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SpecialityDataBuilder grade(Integer grade) {
            this.grade = grade;
            return this;
        }

        public SpecialityData build() {
            SpecialityData specialityData = new SpecialityData();
            specialityData.setIdSpeciality(idSpeciality);
            specialityData.setName(name);
            specialityData.setGrade(grade);
            return specialityData;
        }
    }
}
