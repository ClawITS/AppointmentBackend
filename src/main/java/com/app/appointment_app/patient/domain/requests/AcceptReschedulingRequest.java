package com.app.appointment_app.patient.domain.requests;

import com.app.appointment_app.appointment.domain.model.enums.State;

public class AcceptReschedulingRequest {
    private Long idAppointment;
    private State state;

    @Override
    public String toString() {
        return "AcceptReschedulingRequest{" +
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

    public AcceptReschedulingRequest(Long idAppointment, State state) {
        this.idAppointment = idAppointment;
        this.state = state;
    }
}
