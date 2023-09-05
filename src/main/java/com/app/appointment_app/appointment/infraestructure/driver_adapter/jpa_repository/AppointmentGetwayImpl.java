package com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.appointment.domain.constants.AppointmentResponseMessages;
import com.app.appointment_app.appointment.domain.constants.CloseAppointmentMessages;
import com.app.appointment_app.appointment.domain.getways.business_services.CloseAppointmentGetway;
import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentDeleteGetway;
import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentFindAllGetway;
import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentSaveGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.requests.CloseAppointmentRequest;
import com.app.appointment_app.appointment.domain.responses.AppointmentPaginatorResponse;
import com.app.appointment_app.appointment.domain.responses.CloseAppointmentResponse;
import com.app.appointment_app.appointment.domain.responses.SaveAppointmentResponse;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.s3_repository.AppointmentRepository;
import com.app.appointment_app.appointment.infraestructure.mapper.AppointmentMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AppointmentGetwayImpl implements AppointmentFindAllGetway, AppointmentSaveGetway,
        AppointmentDeleteGetway, AppointmentFindByIdGetway, CloseAppointmentGetway {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentGetwayImpl(AppointmentRepository appointmentRepository,
                                 AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }


    @Override
    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<AppointmentPaginatorResponse> findAllPaginator(int numberPage) {
        int pageSize = 10;
        PageRequest page = PageRequest.of(numberPage, pageSize);
        Page<AppointmentData> data = appointmentRepository.findAll(page);
        List<AppointmentPaginatorResponse> appointmentPaginatorResponses = data.get().map(appointmentData -> new AppointmentPaginatorResponse(appointmentData
                .getDisponibility().getHour(),appointmentData.getPatientData().getName(),
                appointmentData.getDisponibility().getDoctor().getName(), appointmentData.
                getState(), data.getTotalPages())).collect(Collectors.toList());;

        return appointmentPaginatorResponses;
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
        AppointmentData appointmentData2= appointmentMapper.toData(appointment);
        AppointmentData appointmentData = appointmentRepository.save(appointmentData2);
        return new SaveAppointmentResponse(
                appointmentData.getDisponibility().getHour(), appointmentData.getDisponibility().getDoctor().getName(),
                appointmentData.getPatientData().getName(), AppointmentResponseMessages.SAVE_SUCCESSFULlY
        );
    }



    @Override
    public CloseAppointmentResponse closeAppointment(CloseAppointmentRequest closeAppointmentRequest) {

        return new CloseAppointmentResponse(null, CloseAppointmentMessages.ATTEND_APPOINTMENT
                + LocalDateTime.now().toString()
        );
    }
}
