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

    public static final class PatientDataBuilder {
        private Long idPatient;
        private String name;
        private Integer document;
        private Date birthDate;
        private String email;
        private Gender gender;
        private List<AppointmentData> appointmentDataList;

        public PatientDataBuilder() {
        }

        public static PatientDataBuilder aPatientData() {
            return new PatientDataBuilder();
        }

        public PatientDataBuilder idPatient(Long idPatient) {
            this.idPatient = idPatient;
            return this;
        }

        public PatientDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PatientDataBuilder document(Integer document) {
            this.document = document;
            return this;
        }

        public PatientDataBuilder birthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public PatientDataBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PatientDataBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public PatientDataBuilder appointmentDataList(List<AppointmentData> appointmentDataList) {
            this.appointmentDataList = appointmentDataList;
            return this;
        }

        public PatientData build() {
            PatientData patientData = new PatientData();
            patientData.setIdPatient(idPatient);
            patientData.setName(name);
            patientData.setDocument(document);
            patientData.setBirthDate(birthDate);
            patientData.setEmail(email);
            patientData.setGender(gender);
            patientData.setAppointmentDataList(appointmentDataList);
            return patientData;
        }
    }
}
