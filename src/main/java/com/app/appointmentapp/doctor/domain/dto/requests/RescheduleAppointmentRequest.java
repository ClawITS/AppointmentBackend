package com.app.appointmentapp.doctor.domain.dto.requests;

import com.app.appointmentapp.appointment.domain.model.enums.State;

import java.util.Date;
public class RescheduleAppointmentRequest {
    private Date actualHour;
    private Date reschuldeHour;
    private Long idAppointment;
    private State state;
    private String patientName;
    public Date getActualHour() {
        return actualHour;
    }

    public void setActualHour(Date actualHour) {
        this.actualHour = actualHour;
    }

    public Date getReschuldeHour() {
        return reschuldeHour;
    }

    public void setReschuldeHour(Date reschuldeHour) {
        this.reschuldeHour = reschuldeHour;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Long getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(Long idAppointment) {
        this.idAppointment = idAppointment;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @Override
    public String toString() {
        return "RescheduleAppointmentRequest{" +
                "actualHour=" + actualHour +
                ", reschuldeHour=" + reschuldeHour +
                ", idAppointment=" + idAppointment +
                ", state=" + state +
                ", patientName='" + patientName + '\'' +
                '}';
    }

    public RescheduleAppointmentRequest(Date actualHour, Date reschuldeHour, Long idAppointment, State state, String patientName) {
        this.actualHour = actualHour;
        this.reschuldeHour = reschuldeHour;
        this.idAppointment = idAppointment;
        this.state = state;
        this.patientName = patientName;
    }
}
