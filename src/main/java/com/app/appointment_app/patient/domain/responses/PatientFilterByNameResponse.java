package com.app.appointment_app.patient.domain.responses;

import com.app.appointment_app.patient.domain.model.enums.Gender;

import java.util.Date;

public class PatientFilterByNameResponse {
    private Long idPatient;
    private String name;
    private Integer document;
    private Date birthDate;
    private String email;
    private Gender gender;

    @Override
    public String toString() {
        return "PatientFilterByNameResponse{" +
                "idPatient=" + idPatient +
                ", name='" + name + '\'' +
                ", document=" + document +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }

    public PatientFilterByNameResponse(Long idPatient, String name, Integer document, Date birthDate, String email, Gender gender) {
        this.idPatient = idPatient;
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
        this.email = email;
        this.gender = gender;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
