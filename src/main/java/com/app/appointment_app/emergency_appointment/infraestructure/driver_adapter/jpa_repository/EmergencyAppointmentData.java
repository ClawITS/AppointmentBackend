package com.app.appointment_app.emergency_appointment.infraestructure.driver_adapter.jpa_repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity(name = "emergencyAppointments")

public class EmergencyAppointmentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmergencyAppointment;
    private String description;

    public EmergencyAppointmentData(Long idEmergencyAppointment, String description) {
        this.idEmergencyAppointment = idEmergencyAppointment;
        this.description = description;
    }

    public EmergencyAppointmentData() {
    }

    @Override
    public String toString() {
        return "EmergencyAppointmentData{" +
                "idEmergencyAppointment=" + idEmergencyAppointment +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getIdEmergencyAppointment() {
        return idEmergencyAppointment;
    }

    public void setIdEmergencyAppointment(Long idEmergencyAppointment) {
        this.idEmergencyAppointment = idEmergencyAppointment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
