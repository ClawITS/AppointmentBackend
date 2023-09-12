package com.app.appointment_app.appointment.domain.ports.requests;

import com.app.appointment_app.appointment.domain.model.enums.State;

public class CloseAppointmentRequest {
    private Long idAppointment;
    private State state;

    public CloseAppointmentRequest(Long idAppointment, State state) {
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
