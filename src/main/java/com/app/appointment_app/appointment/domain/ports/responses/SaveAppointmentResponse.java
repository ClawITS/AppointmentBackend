package com.app.appointment_app.appointment.domain.ports.responses;

import java.util.Date;

public class SaveAppointmentResponse {
    private Date hour;
    private String doctor;
    private String patient;
    private String message;

    public Date getHour() {
        return hour;
    }

    public SaveAppointmentResponse(Date hour, String doctor, String patient, String message) {
        this.hour = hour;
        this.doctor = doctor;
        this.patient = patient;
        this.message = message;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
