package com.app.appointment_app.appointment.domain.model;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.patient.domain.model.Patient;

public class Appointment {
    private Long idAppointment;
    private Disponibility disponibility;
    private Patient patient;

    private State state;

    public Appointment() {
    }

    public Appointment(Long idAppointment, Disponibility disponibility, Patient patient, State state) {
        this.idAppointment = idAppointment;
        this.disponibility = disponibility;
        this.patient = patient;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "idAppointment=" + idAppointment +
                ", disponibility=" + disponibility +
                ", patient=" + patient +
                ", state=" + state +
                '}';
    }

    public Disponibility getDisponibility() {
        return disponibility;
    }

    public void setDisponibility(Disponibility disponibility) {
        this.disponibility = disponibility;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
