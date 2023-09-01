package com.app.appointment_app.doctor.domain.requests;

import com.app.appointment_app.appointment.domain.model.enums.State;

import java.util.Date;

public class RescheduleAppointmentRequest {
    private Date actualHour;
    private Date reschuldeHour;
    private Long idAppointment;
    private State state;
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

    public RescheduleAppointmentRequest(Date actualHour, Date reschuldeHour, Long idAppointment, State state) {
        this.actualHour = actualHour;
        this.reschuldeHour = reschuldeHour;
        this.idAppointment = idAppointment;
        this.state = state;
    }
}
