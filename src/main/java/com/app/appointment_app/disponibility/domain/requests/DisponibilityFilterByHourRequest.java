package com.app.appointment_app.disponibility.domain.requests;

import java.util.Date;

public class DisponibilityFilterByHourRequest {
    private Date startDate;
    private Date endDate;

    public DisponibilityFilterByHourRequest(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
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
}
