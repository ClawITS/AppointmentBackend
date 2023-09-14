package com.app.appointment_app.doctor.domain.responses;

import java.util.Date;

public class RescheduleAppointmentResponse {
    private Date newHour;
    private Date lastHour;
    private String messageResponse;

    public RescheduleAppointmentResponse(Date newHour, Date lastHour, String messageResponse) {
        this.newHour = newHour;
        this.lastHour = lastHour;
        this.messageResponse = messageResponse;
    }

    public Date getNewHour() {
        return newHour;
    }

    public void setNewHour(Date newHour) {
        this.newHour = newHour;
    }

    public Date getLastHour() {
        return lastHour;
    }

    public void setLastHour(Date lastHour) {
        this.lastHour = lastHour;
    }

    public String getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }
}
