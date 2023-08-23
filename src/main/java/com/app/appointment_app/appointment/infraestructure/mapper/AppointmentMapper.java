package com.app.appointment_app.appointment.infraestructure.mapper;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository.AppointmentData;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    public Appointment toAppointment(AppointmentData appointmentData){
        return new Appointment(appointmentData.getIdAppointment(),appointmentData.getState());
    }

    public AppointmentData toData(Appointment appointment){
        return new AppointmentData(appointment.getIdAppointment(),appointment.getState());
    }
}
