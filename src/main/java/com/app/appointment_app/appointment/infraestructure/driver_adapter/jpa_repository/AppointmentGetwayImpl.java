package com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.appointment.domain.constants.AppointmentResponseMessages;
import com.app.appointment_app.appointment.domain.getways.*;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.requests.CloseAppointmentRequest;
import com.app.appointment_app.appointment.domain.responses.CloseAppointmentResponse;
import com.app.appointment_app.appointment.domain.responses.SaveAppointmentResponse;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.helper.AppointmentSaveHelper;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.helper.CloseAppointmentHelper;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.s3_repository.AppointmentRepository;
import com.app.appointment_app.appointment.infraestructure.mapper.AppointmentMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AppointmentGetwayImpl implements AppointmentFindAllGetway, AppointmentSaveGetway,
        AppointmentDeleteGetway, AppointmentFindByIdGetway, CloseAppointmentGetway {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final AppointmentSaveHelper appointmentSaveHelper;
    private final CloseAppointmentHelper closeAppointmentHelper;

    public AppointmentGetwayImpl(AppointmentRepository appointmentRepository,
                                 AppointmentMapper appointmentMapper, AppointmentSaveHelper appointmentSaveHelper, CloseAppointmentHelper closeAppointmentHelper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
        this.appointmentSaveHelper = appointmentSaveHelper;
        this.closeAppointmentHelper = closeAppointmentHelper;
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
    public SaveAppointmentResponse save(Appointment appointment) {
        AppointmentData appointmentData =
                appointmentSaveHelper.saveByControl(appointment);
        SaveAppointmentResponse saveAppointmentResponse = new SaveAppointmentResponse(
                appointmentData.getDisponibility().getHour(), appointmentData.getDisponibility().getDoctor().getName(),
                appointmentData.getPatientData().getName(), AppointmentResponseMessages.SAVE_SUCCESSFULlY
        );
        return saveAppointmentResponse;
    }



    @Override
    public CloseAppointmentResponse closeAppointment(CloseAppointmentRequest closeAppointmentRequest) {
        return closeAppointmentHelper.attendAppointment(closeAppointmentRequest);
    }
}
