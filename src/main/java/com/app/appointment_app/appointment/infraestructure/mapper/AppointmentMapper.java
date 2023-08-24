package com.app.appointment_app.appointment.infraestructure.mapper;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository.AppointmentData;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.doctor.domain.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    public Appointment toAppointment(AppointmentData appointmentData){
        Disponibility disp = new Disponibility();
        Doctor doctor = new Doctor();
        doctor.setIdDoctor(appointmentData.getDisponibility().getDoctor().getIdDoctor());
        doctor.setDescription(appointmentData.getDisponibility().getDoctor().getDescription());
        disp.setDoctor(doctor);
        disp.setHour(appointmentData.getDisponibility().getHour());
        return new Appointment(appointmentData.getIdAppointment(),disp,null,appointmentData.getState());
    }

    public AppointmentData toData(Appointment appointment){
        return new AppointmentData(appointment.getIdAppointment(),null, null, appointment.getState());
    }
}
