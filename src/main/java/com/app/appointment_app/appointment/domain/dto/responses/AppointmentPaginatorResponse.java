package com.app.appointment_app.appointment.domain.dto.responses;
import com.app.appointment_app.appointment.domain.model.enums.State;
import java.util.Date;

public class AppointmentPaginatorResponse {
    private Date hourAndDate;
    private String patientName;
    private String doctorName;
    private State state;
    private int totalPages;

    @Override
    public String toString() {
        return "AppointmentPaginatorResponse{" +
                "hourAndDate=" + hourAndDate +
                ", patientName='" + patientName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", state=" + state +
                ", totalPages=" + totalPages +
                '}';
    }

    public AppointmentPaginatorResponse(Date hourAndDate, String patientName, String doctorName, State state, int totalPages) {
        this.hourAndDate = hourAndDate;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.state = state;
        this.totalPages = totalPages;
    }

    public Date getHourAndDate() {
        return hourAndDate;
    }

    public void setHourAndDate(Date hourAndDate) {
        this.hourAndDate = hourAndDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
