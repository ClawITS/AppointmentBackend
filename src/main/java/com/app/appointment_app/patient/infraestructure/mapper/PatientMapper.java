package com.app.appointment_app.patient.infraestructure.mapper;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository.DoctorData;
import com.app.appointment_app.patient.domain.model.Patient;
import com.app.appointment_app.patient.infraestructure.driver_adapter.jpa_repository.PatientData;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientMapper {


    public Patient toPatient(PatientData patientData) {
        List<Appointment> appointmentList = null;
        if(patientData.getAppointmentDataList() != null){
            appointmentList = listAppointmentDataToAppointmentList(patientData);
        }
         
        return new Patient(patientData.getIdPatient(), patientData.getName(), patientData.getDocument(), patientData.getBirthDate(),
                patientData.getEmail(), patientData.getGender(), appointmentList);
    }

    private List<Appointment> listAppointmentDataToAppointmentList(PatientData patientData) {
        return patientData.getAppointmentDataList().stream().map(
                appointmentData -> new Appointment(appointmentData.getIdAppointment(),
                        disponibilityDataToDisponibility(appointmentData.getDisponibility()
                        ), new Patient(patientData.getIdPatient(), patientData.getName(), patientData.getDocument()
                        , patientData.getBirthDate(), patientData.getEmail(), patientData.getGender(),
                        null), appointmentData.getState())
        ).collect(Collectors.toList());
    }

    public Disponibility disponibilityDataToDisponibility(DisponibilityData disponibilityData){
        return new Disponibility(disponibilityData.getIdDisponibility(), disponibilityData.getHour(),
                doctorDataToDoctor(disponibilityData.getDoctor()), disponibilityData.getDisponibilityState());
    }
    public Doctor doctorDataToDoctor(DoctorData doctorData){
        return new Doctor(doctorData.getIdDoctor(),doctorData.getName(), doctorData.getDescription(),
                null);
    }
    public PatientData toData(Patient patient) {
        return new PatientData(patient.getIdPatient(), patient.getName(), patient.getDocument(), patient.getBirthDate(),
                patient.getEmail(), patient.getGender(), null);
    }
}
