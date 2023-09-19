package com.app.appointmentapp.appointment.infraestructure.adapter.db.sql.mysql.mapper;
import com.app.appointmentapp.appointment.domain.dto.responses.SaveAppointmentResponse;
import com.app.appointmentapp.appointment.infraestructure.adapter.db.sql.mysql.entity.AppointmentData;
import org.springframework.stereotype.Component;

@Component
public class SaveResponseMapper {
    public SaveAppointmentResponse toSaveResponseMapper(AppointmentData appointment){
        return new SaveAppointmentResponse(appointment.getDisponibility().getHour(),
                appointment.getDisponibility().getDoctor().getName(),
                appointment.getPatientData().getName());
    }
}
