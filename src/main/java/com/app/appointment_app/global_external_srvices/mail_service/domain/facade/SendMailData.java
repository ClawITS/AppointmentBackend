package com.app.appointment_app.global_external_srvices.mail_service.domain.facade;

public class SendMailData {
    private String addressee;
    private String affair;
    private String message;

    @Override
    public String toString() {
        return "SendMailData{" +
                "addressee='" + addressee + '\'' +
                ", affair='" + affair + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getAffair() {
        return affair;
    }

    public void setAffair(String affair) {
        this.affair = affair;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SendMailData(String addressee, String affair, String message) {
        this.addressee = addressee;
        this.affair = affair;
        this.message = message;
    }
}
