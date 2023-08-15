package com.app.appointment_app.emergency_appointment.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyAppointment {
    private Long idEmergencyAppointment;
    private String description;
}
