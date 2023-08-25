package com.app.appointment_app.appointment.infraestructure.mapper;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository.AppointmentData;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.patient.domain.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    public Appointment toAppointment(AppointmentData appointmentData){
        Disponibility disponibility = new Disponibility();
        Patient patient = new Patient();
        chargePatient(appointmentData, patient);
        chargeDisponibility(appointmentData, disponibility);
        return new Appointment(appointmentData.getIdAppointment(),disponibility,patient,appointmentData.getState());
    }
    private void chargePatient(AppointmentData appointmentData, Patient patient) {
        patient.setIdPatient(appointmentData.getPatientData().getIdPatient());
        patient.setName(appointmentData.getPatientData().getName());
        patient.setDocument(appointmentData.getPatientData().getDocument());
        patient.setEmail(appointmentData.getPatientData().getEmail());
        patient.setGender(appointmentData.getPatientData().getGender());
        patient.setBirthDate(appointmentData.getPatientData().getBirthDate());
    }

    private void chargeDisponibility(AppointmentData appointmentData, Disponibility disp) {
        Doctor doctor = new Doctor();
        doctor.setIdDoctor(appointmentData.getDisponibility().getDoctor().getIdDoctor());
        doctor.setName(appointmentData.getDisponibility().getDoctor().getName());
        doctor.setDescription(appointmentData.getDisponibility().getDoctor().getDescription());
        disp.setIdDisponibility(appointmentData.getIdAppointment());
        disp.setDoctor(doctor);
        disp.setHour(appointmentData.getDisponibility().getHour());
        disp.setDisponibilityState(appointmentData.getDisponibility().getDisponibilityState());
    }

    public AppointmentData toData(Appointment appointment){
        return new AppointmentData(appointment.getIdAppointment(),null, null, appointment.getState());
    }
}
