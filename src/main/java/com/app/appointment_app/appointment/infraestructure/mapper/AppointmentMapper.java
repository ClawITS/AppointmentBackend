package com.app.appointment_app.appointment.infraestructure.mapper;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository.AppointmentData;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository.DoctorData;
import com.app.appointment_app.patient.domain.model.Patient;
import com.app.appointment_app.patient.infraestructure.driver_adapter.jpa_repository.PatientData;
import org.springframework.beans.factory.annotation.Autowired;
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
        disp.setIdDisponibility(appointmentData.getDisponibility().getIdDisponibility());
        disp.setDoctor(doctor);
        disp.setHour(appointmentData.getDisponibility().getHour());
        disp.setDisponibilityState(appointmentData.getDisponibility().getDisponibilityState());
    }

    public AppointmentData toData(Appointment appointment){
        return new AppointmentData(appointment.getIdAppointment(),this.toDisponibilityData(appointment.getDisponibility())
                , this.toPatientData(appointment.getPatient()), appointment.getState());
    }
    public PatientData toPatientData(Patient patient){
        return new PatientData(patient.getIdPatient(), patient.getName(), patient.getDocument(), patient.getBirthDate(),
                patient.getEmail(), patient.getGender(), null);
    }
    public DisponibilityData toDisponibilityData(Disponibility disponibility){

        return new DisponibilityData(disponibility.getIdDisponibility(),disponibility.getHour(),
               this.toDoctorData(disponibility.getDoctor()),disponibility.getDisponibilityState());
    }
    public DoctorData toDoctorData(Doctor doctor){
        return new DoctorData(doctor.getIdDoctor(), doctor.getName(), doctor.getDescription(),
                null);
    }
}
