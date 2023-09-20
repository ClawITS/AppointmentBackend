package com.app.appointmentapp.doctor.domain.dto.requests;

import com.app.appointmentapp.appointment.domain.model.enums.State;

public class AcceptPatientReschedulingRequest {
    private Long idAppointment;
    private State state;

    @Override
    public String toString() {
        return "AcceptPtientReschedulingRequest{" +
                "idAppointment=" + idAppointment +
                ", state=" + state +
                '}';
    }

    public AcceptPatientReschedulingRequest(Long idAppointment, State state) {
        this.idAppointment = idAppointment;
        this.state = state;
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
