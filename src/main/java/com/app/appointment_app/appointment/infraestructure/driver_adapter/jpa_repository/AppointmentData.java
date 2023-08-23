package com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.appointment.domain.model.enums.State;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="appointments")

public class AppointmentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAppointment;
    private State state;

    @Override
    public String toString() {
        return "AppointmentData{" +
                "idAppointment=" + idAppointment +
                ", state=" + state +
                '}';
    }

    public AppointmentData(Long idAppointment, State state) {
        this.idAppointment = idAppointment;
        this.state = state;
    }

    public AppointmentData() {
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
