package com.app.Appointment.EmergencyAppointment.infraestructure.driver_adapter.jpa_repository;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "emergencyAppointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyAppointmentData {
    private Long idEmergencyAppointment;
    private String description;
}
