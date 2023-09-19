package com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.mapper;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.entity.AppointmentData;
import com.app.appointment_app.commons.domain.mappers.SpecialityCommonMapper;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.infraestructure.adapter.db.sql.mysql.entity.DisponibilityData;
import com.app.appointment_app.disponibility.infraestructure.adapter.db.sql.mysql.mapper.DisponibilityMapper;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.infraestructure.adapter.db.sql.mysql.entity.DoctorData;
import com.app.appointment_app.doctor.infraestructure.adapter.db.sql.mysql.mapper.DoctorMapper;
import com.app.appointment_app.patient.domain.model.Patient;
import com.app.appointment_app.patient.infraestructure.adapter.db.sql.mysql.entity.PatientData;
import com.app.appointment_app.patient.infraestructure.adapter.db.sql.mysql.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class AppointmentMapper {
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private DisponibilityMapper disponibilityMapper;
    @Autowired
    private PatientMapper patientMapper;
    public Appointment toAppointment(AppointmentData appointmentData){
        Disponibility disponibility = null;
        Patient patient = null;
        if(!isNull(appointmentData.getDisponibility())){
            disponibility = disponibilityMapper.toDisponibility(appointmentData.getDisponibility());
        }
        if(!isNull(appointmentData.getPatientData())){
            patient = patientMapper.toPatient(appointmentData.getPatientData());
        }
        return new Appointment.AppointmentBuilder()
                .idAppointment(appointmentData.getIdAppointment())
                .disponibility(disponibility)
                .patient(patient)
                .state(appointmentData.getState())
                .build();
    }


    public AppointmentData toData(Appointment appointment){
        return new AppointmentData.AppointmentDataBuilder()
                .idAppointment(appointment.getIdAppointment())
                .disponibility(this.toDisponibilityData(appointment.getDisponibility()))
                .patient(patientMapper.toData(appointment.getPatient()))
                .state(appointment.getState())
                .build();
    }

    public DisponibilityData toDisponibilityData(Disponibility disponibility){
if(isNull(disponibility)){
    return null;
}
        return new DisponibilityData(disponibility.getIdDisponibility(),disponibility.getHour(),
                doctorMapper.toData(disponibility.getDoctor()),disponibility.getDisponibilityState());
    }


}
