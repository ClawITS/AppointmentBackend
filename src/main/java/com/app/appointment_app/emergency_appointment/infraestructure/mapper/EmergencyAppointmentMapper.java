package com.app.appointment_app.emergency_appointment.infraestructure.mapper;

import com.app.appointment_app.emergency_appointment.domain.model.EmergencyAppointment;
import com.app.appointment_app.emergency_appointment.infraestructure.driver_adapter.jpa_repository.EmergencyAppointmentData;
import org.springframework.stereotype.Component;

@Component
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
