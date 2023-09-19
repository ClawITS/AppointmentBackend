package com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.mapper;
import com.app.appointment_app.appointment.domain.dto.responses.SaveAppointmentResponse;
import com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.entity.AppointmentData;
import org.springframework.stereotype.Component;

@Component
public class SaveResponseMapper {
    public SaveAppointmentResponse toSaveResponseMapper(AppointmentData appointment){
        return new SaveAppointmentResponse(appointment.getDisponibility().getHour(),
                appointment.getDisponibility().getDoctor().getName(),
                appointment.getPatientData().getName());
    }
}
