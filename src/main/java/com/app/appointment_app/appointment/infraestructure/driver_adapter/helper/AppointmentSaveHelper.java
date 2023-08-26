package com.app.appointment_app.appointment.infraestructure.driver_adapter.helper;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository.AppointmentData;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.s3_repository.AppointmentRepository;
import com.app.appointment_app.appointment.infraestructure.mapper.AppointmentMapper;
import com.app.appointment_app.disponibility.domain.model.enums.DisponibilityState;
import com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import com.app.appointment_app.disponibility.infraestructure.driver_adapter.s3_repository.DisponibilityRepository;
import com.app.appointment_app.patient.infraestructure.driver_adapter.jpa_repository.PatientData;
import com.app.appointment_app.patient.infraestructure.driver_adapter.s3_repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class AppointmentSaveHelper {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final PatientRepository patientRepository;
    private final DisponibilityRepository disponibilityRepository;

    public AppointmentSaveHelper(AppointmentRepository appointmentRepository,
                                 AppointmentMapper appointmentMapper, PatientRepository patientRepository,
                                 DisponibilityRepository disponibilityRepository) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
        this.patientRepository = patientRepository;
        this.disponibilityRepository = disponibilityRepository;
    }
    public Optional<AppointmentData> appointmentDataChargeAndControlState(Appointment appointment) {
        Optional<AppointmentData> appointmentData;
        if(isNull(appointment.getIdAppointment())){
            appointmentData = chargeAppointmentData(appointment);
        }else {
            appointmentData = appointmentRepository.findById(appointment.getIdAppointment());
            if(appointment.getState().equals(State.ATTENDED)){
                appointmentData.get().getDisponibility().setDisponibilityState(DisponibilityState.CLOSED);
            }
            appointmentData.get().setState(appointment.getState());
        }
        return appointmentData;
    }
    private Optional<AppointmentData> chargeAppointmentData(Appointment appointment) {
        Optional<AppointmentData> appointmentData;
        Optional<DisponibilityData> disponibilityData = disponibilityRepository.findById(appointment.getDisponibility().getIdDisponibility());
        Optional<PatientData> patientData = patientRepository.findById(appointment.getPatient().getIdPatient());
        appointmentData = Optional.ofNullable(appointmentMapper.toData(appointment));
        disponibilityData.get().setDisponibilityState(DisponibilityState.BUSY);
        appointmentData.get().setDisponibility(disponibilityData.get());
        appointmentData.get().setPatientData(patientData.get());
        appointmentData.get().setState(State.OPEN);
        return appointmentData;
    }
}
