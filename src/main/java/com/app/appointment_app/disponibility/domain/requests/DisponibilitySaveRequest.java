package com.app.appointment_app.disponibility.domain.requests;

import java.util.Date;

public class DisponibilitySaveRequest {
    private Date hour;
    private Long idDoctor;

    @Override
    public String toString() {
        return "DisponibilitySaveRequest{" +
                "hour=" + hour +
                ", idDoctor=" + idDoctor +
                '}';
    }

    public DisponibilitySaveRequest(Date hour, Long idDoctor) {
        this.hour = hour;
        this.idDoctor = idDoctor;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }
}