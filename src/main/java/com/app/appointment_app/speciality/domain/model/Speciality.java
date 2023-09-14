package com.app.appointment_app.speciality.domain.model;
public class Speciality {
    private Long idSpeciality;
    private String name;
    private Integer grade;

    public Speciality() {
        // TODO document why this constructor is empty
    }
    public Speciality(Long idSpeciality, String name, Integer grade) {
        this.idSpeciality = idSpeciality;
        this.name = name;
        this.grade = grade;
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
}
