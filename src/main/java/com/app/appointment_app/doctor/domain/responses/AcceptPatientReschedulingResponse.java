package com.app.appointment_app.doctor.domain.responses;

public class AcceptPatientReschedulingResponse {
    private String messageResponse;

    public String getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }

    public AcceptPatientReschedulingResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }

    @Override
    public String toString() {
        return "AcceptPatientReschedulingResponse{" +
                "messageResponse='" + messageResponse + '\'' +
                '}';
    }
}
