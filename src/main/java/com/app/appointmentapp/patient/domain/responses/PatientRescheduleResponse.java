package com.app.appointmentapp.patient.domain.responses;

public class PatientRescheduleResponse {
    private String messageResponse;

    @Override
    public String toString() {
        return "PatientRescheduleResponse{" +
                "messageResponse='" + messageResponse + '\'' +
                '}';
    }

    public PatientRescheduleResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }

    public String getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }
}
