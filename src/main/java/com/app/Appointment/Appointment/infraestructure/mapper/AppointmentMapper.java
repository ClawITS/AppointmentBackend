package com.app.Appointment.Appointment.infraestructure.mapper;

import com.app.Appointment.Appointment.domain.model.Appointment;
import com.app.Appointment.Appointment.infraestructure.driver_adapter.jpa_repository.AppointmentData;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class AppointmentMapper {
    public Appointment toAppointment(AppointmentData appointmentData){
        return new Appointment(appointmentData.getIdAppointment(),appointmentData.getState());
    }

    public AppointmentData toData(Appointment appointment){
        return new AppointmentData(appointment.getIdAppointment(),appointment.getState());
    }
}
