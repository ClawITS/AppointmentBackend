package com.app.Appointment.EmergencyAppointment.infraestructure.driver_adapter.jpa_repository;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity(name = "emergencyAppointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyAppointmentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmergencyAppointment;
    private String description;
}
