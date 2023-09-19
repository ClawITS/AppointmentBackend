package com.app.appointmentapp.patient.domain.requests;

import com.app.appointmentapp.appointment.domain.model.enums.State;

import java.util.Date;

public class PatientRescheduleRequest {
    private Long idAppointment;
    private State state;
    private Date newDate;

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }

    public PatientRescheduleRequest(Long idAppointment, State state, Date newDate) {
        this.idAppointment = idAppointment;
        this.state = state;
        this.newDate = newDate;
    }

    @Override
    public String toString() {
        return "PatientRescheduleRequest{" +
                "idAppointment=" + idAppointment +
                ", state=" + state +
                ", newDate=" + newDate +
                '}';
    }

    public Long getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(Long idAppointment) {
        this.idAppointment = idAppointment;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
