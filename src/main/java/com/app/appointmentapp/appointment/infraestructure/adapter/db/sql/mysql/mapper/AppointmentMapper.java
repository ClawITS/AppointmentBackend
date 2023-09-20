package com.app.appointmentapp.appointment.infraestructure.adapter.db.sql.mysql.mapper;

import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.appointment.infraestructure.adapter.db.sql.mysql.entity.AppointmentData;
import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.infraestructure.adapter.db.sql.mysql.entity.DisponibilityData;
import com.app.appointmentapp.disponibility.infraestructure.adapter.db.sql.mysql.mapper.DisponibilityMapper;
import com.app.appointmentapp.doctor.infraestructure.adapter.db.sql.mysql.mapper.DoctorMapper;
import com.app.appointmentapp.patient.domain.model.Patient;
import com.app.appointmentapp.patient.infraestructure.adapter.db.sql.mysql.mapper.PatientMapper;
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
