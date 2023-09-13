package com.app.appointment_app.appointment.domain.ports.responses;

import com.app.appointment_app.appointment.domain.model.enums.State;

public class AppointmentFindStateByIdResponse {
    private Long idAppointment;
    private State state;

    @Override
    public String toString() {
        return "AppointmentFindStateByIdResponse{" +
                "idAppointment=" + idAppointment +
                ", state=" + state +
                '}';
    }

    public AppointmentFindStateByIdResponse(Long idAppointment, State state) {
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
