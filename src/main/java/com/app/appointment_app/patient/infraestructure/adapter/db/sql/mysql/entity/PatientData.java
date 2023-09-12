package com.app.appointment_app.patient.infraestructure.adapter.db.sql.mysql.entity;

import com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.entity.AppointmentData;
import com.app.appointment_app.patient.domain.model.enums.Gender;
import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity(name = "patients")
public class PatientData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    private String name;
    private Integer document;
    private Date birthDate;
    private String email;
    private Gender gender;

    @OneToMany(mappedBy = "patient")
    private List<AppointmentData> appointmentDataList;

    @Override
    public String toString() {
        return "PatientData{" +
                "idPatient=" + idPatient +
                ", name='" + name + '\'' +
                ", document=" + document +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", appointmentDataList=" + appointmentDataList +
                '}';
    }

    public PatientData(Long idPatient, String name, Integer document, Date birthDate, String email, Gender gender, List<AppointmentData> appointmentDataList) {
        this.idPatient = idPatient;
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
        this.email = email;
        this.gender = gender;
        this.appointmentDataList = appointmentDataList;
    }

    public PatientData() {
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

    public List<AppointmentData> getAppointmentDataList() {
        return appointmentDataList;
    }

    public void setAppointmentDataList(List<AppointmentData> appointmentDataList) {
        this.appointmentDataList = appointmentDataList;
    }
}
