package com.app.Appointment.Appointment.infraestructure.driver_adapter.jpa_repository;

import com.app.Appointment.Appointment.domain.model.enums.State;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAppointment;
    private State state;

}
