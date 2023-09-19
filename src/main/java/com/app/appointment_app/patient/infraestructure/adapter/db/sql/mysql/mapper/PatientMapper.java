package com.app.appointment_app.patient.infraestructure.adapter.db.sql.mysql.mapper;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.infraestructure.adapter.db.sql.mysql.entity.DisponibilityData;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.infraestructure.adapter.db.sql.mysql.entity.DoctorData;
import com.app.appointment_app.patient.domain.model.Patient;
import com.app.appointment_app.patient.infraestructure.adapter.db.sql.mysql.entity.PatientData;
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
        return new PatientData.PatientDataBuilder()
                .idPatient(patient.getIdPatient())
                .name(patient.getName())
                .document(patient.getDocument())
                .birthDate(patient.getBirthDate())
                .email(patient.getEmail())
                .gender(patient.getGender())
                .build();
    }
}
