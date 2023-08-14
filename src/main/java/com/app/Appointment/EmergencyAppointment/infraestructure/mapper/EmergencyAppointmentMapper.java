package com.app.Appointment.EmergencyAppointment.infraestructure.mapper;

import com.app.Appointment.EmergencyAppointment.domain.model.EmergencyAppointment;
import com.app.Appointment.EmergencyAppointment.infraestructure.driver_adapter.jpa_repository.EmergencyAppointmentData;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class EmergencyAppointmentMapper {
    public EmergencyAppointment toEmergencyAppointment(EmergencyAppointmentData emergencyAppointmentData){
        return new EmergencyAppointment(emergencyAppointmentData.getIdEmergencyAppointment(),
                emergencyAppointmentData.getDescription());
    }
    public EmergencyAppointmentData toData(EmergencyAppointment emergencyAppointment){
        return new EmergencyAppointmentData(emergencyAppointment.getIdEmergencyAppointment(),
                emergencyAppointment.getDescription());
    }
}
