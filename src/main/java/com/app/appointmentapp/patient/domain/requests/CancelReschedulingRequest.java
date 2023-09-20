package com.app.appointmentapp.patient.domain.requests;

import com.app.appointmentapp.appointment.domain.model.enums.State;

public class CancelReschedulingRequest {
    private Long idAppointment;
    private State state;

    @Override
    public String toString() {
        return "CancelReschedulingRequest{" +
                "idAppointment=" + idAppointment +
                ", state=" + state +
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

    public CancelReschedulingRequest(Long idAppointment, State state) {
        this.idAppointment = idAppointment;
        this.state = state;
    }
}
