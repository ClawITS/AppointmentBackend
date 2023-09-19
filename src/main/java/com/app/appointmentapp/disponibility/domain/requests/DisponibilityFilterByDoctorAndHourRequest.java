package com.app.appointmentapp.disponibility.domain.requests;

import java.util.Date;

public class DisponibilityFilterByDoctorAndHourRequest {
    private Date startDate;
    private Date endDate;
    private Long doctorId;

    @Override
    public String toString() {
        return "DisponibilityFilterByDoctorAndHourRequest{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", doctorId=" + doctorId +
                '}';
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public DisponibilityFilterByDoctorAndHourRequest(Date startDate, Date endDate, Long doctorId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.doctorId = doctorId;
    }
}
