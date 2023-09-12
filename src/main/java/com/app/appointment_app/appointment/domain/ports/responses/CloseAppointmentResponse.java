package com.app.appointment_app.appointment.domain.ports.responses;
import com.app.appointment_app.appointment.domain.model.enums.State;

import java.util.Date;

public class CloseAppointmentResponse {
    private Date hour;
    private String messageResponse;

    public CloseAppointmentResponse(Date hour, String messageResponse) {
        this.hour = hour;
        this.messageResponse = messageResponse;
    }

    @Override
    public String toString() {
        return "CloseAppointmentResponse{" +
                "hour=" + hour +
                ", messageResponse='" + messageResponse + '\'' +
                '}';
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public String getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }
}
