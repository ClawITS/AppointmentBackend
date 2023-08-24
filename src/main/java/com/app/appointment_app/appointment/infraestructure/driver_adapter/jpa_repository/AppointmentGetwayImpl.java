package com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.appointment.domain.getways.AppointmentFindAllGetway;
import com.app.appointment_app.appointment.domain.getways.AppointmentSaveGetway;
import com.app.appointment_app.appointment.domain.getways.AppointmentDeleteGetway;
import com.app.appointment_app.appointment.domain.getways.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.s3_repository.AppointmentRepository;
import com.app.appointment_app.appointment.infraestructure.mapper.AppointmentMapper;

import com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import com.app.appointment_app.disponibility.infraestructure.driver_adapter.s3_repository.DisponibilityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AppointmentGetwayImpl implements AppointmentFindAllGetway, AppointmentSaveGetway, AppointmentDeleteGetway, AppointmentFindByIdGetway {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    private final DisponibilityRepository disponibilityRepository;

    public AppointmentGetwayImpl(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper, DisponibilityRepository disponibilityRepository) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
        this.disponibilityRepository = disponibilityRepository;
    }

    @Override
    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public Page<Appointment> findAllPaginator(int numberPage) {
        int pageSize = 10;
        PageRequest page = PageRequest.of(numberPage, pageSize);
        Page<AppointmentData> data = appointmentRepository.findAll(page);
        return data.map(appointmentMapper::toAppointment);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll().stream()
                .map(appointmentMapper::toAppointment)
                .collect(Collectors.toList());
    }

    @Override
    public Appointment findById(Long id) {
        Optional<AppointmentData> data = appointmentRepository.findById(id);
        return appointmentMapper.toAppointment(data.get());
    }

    @Override
    public Appointment save(Appointment appointment) {
        Optional<DisponibilityData> data = disponibilityRepository.findById(appointment.getDisponibility().getIdDisponibility());
        AppointmentData appointmentData = appointmentMapper.toData(appointment);
        appointmentData.setDisponibility(data.get());
        return appointmentMapper
                .toAppointment(appointmentRepository.save(appointmentData));
    }
}
