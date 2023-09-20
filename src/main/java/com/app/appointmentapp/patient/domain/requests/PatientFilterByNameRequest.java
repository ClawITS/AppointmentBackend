package com.app.appointmentapp.patient.domain.requests;

public class PatientFilterByNameRequest {
    private String name;
    private int numberPage;

    @Override
    public String toString() {
        return "PatientFilterByNameRequest{" +
                "name='" + name + '\'' +
                ", numberPage=" + numberPage +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public PatientFilterByNameRequest(String name, int numberPage) {
        this.name = name;
        this.numberPage = numberPage;
    }
}
