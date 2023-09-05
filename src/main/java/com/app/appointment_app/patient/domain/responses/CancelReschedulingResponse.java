package com.app.appointment_app.patient.domain.responses;

public class CancelReschedulingResponse {
    private String message;

    public CancelReschedulingResponse(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CancelReschedulingResponse{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
