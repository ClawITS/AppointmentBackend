package com.app.appointmentapp.emergency_appointment.infraestructure.adapter.db.sql.mysql.mapper;

import com.app.appointmentapp.emergency_appointment.domain.model.EmergencyAppointment;
import com.app.appointmentapp.emergency_appointment.infraestructure.adapter.db.sql.mysql.entity.EmergencyAppointmentData;
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
