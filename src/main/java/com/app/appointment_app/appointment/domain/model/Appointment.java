package com.app.appointment_app.appointment.domain.model;

import com.app.appointment_app.appointment.domain.model.enums.State;

public class Appointment {
    private Long idAppointment;
    private State state;

    public Appointment() {
    }

    public Appointment(Long idAppointment, State state) {
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
