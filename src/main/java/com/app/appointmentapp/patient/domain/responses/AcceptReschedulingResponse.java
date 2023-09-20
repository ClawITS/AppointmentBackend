package com.app.appointmentapp.patient.domain.responses;

public class AcceptReschedulingResponse {
    private String message;

    @Override
    public String toString() {
        return "AcceptReschedulingResponse{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AcceptReschedulingResponse(String message) {
        this.message = message;
    }
}
