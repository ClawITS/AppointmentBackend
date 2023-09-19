package com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.implgetway;
import com.app.appointment_app.appointment.domain.constants.AppointmentResponseMessages;
import com.app.appointment_app.appointment.domain.constants.CloseAppointmentMessages;
import com.app.appointment_app.appointment.domain.getways.business_services.CloseAppointmentGetway;
import com.app.appointment_app.appointment.domain.getways.cruds.*;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.appointment.domain.dto.requests.CloseAppointmentRequest;
import com.app.appointment_app.appointment.domain.dto.responses.AppointmentPaginatorResponse;
import com.app.appointment_app.appointment.domain.dto.responses.CloseAppointmentResponse;
import com.app.appointment_app.appointment.domain.dto.responses.SaveAppointmentResponse;
import com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.entity.AppointmentData;
import com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.jpa_repository.AppointmentRepository;
import com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.mapper.AppointmentMapper;
import com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.mapper.SaveResponseMapper;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AppointmentGetwayImpl implements AppointmentFindAllGetway, AppointmentSaveGetway,
        AppointmentDeleteGetway, AppointmentFindByIdGetway, CloseAppointmentGetway
        ,AppointmentUpdateStateGetway{
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final SaveResponseMapper saveResponseMapper;

    public AppointmentGetwayImpl(AppointmentRepository appointmentRepository,
                                 AppointmentMapper appointmentMapper, SaveResponseMapper saveResponseMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
        this.saveResponseMapper = saveResponseMapper;
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
        AppointmentData appointmentData = appointmentRepository.save(appointmentMapper.toData(appointment));
        return saveResponseMapper.toSaveResponseMapper(appointmentData);
    }



    @Override
    public CloseAppointmentResponse closeAppointment(CloseAppointmentRequest closeAppointmentRequest) {

        return new CloseAppointmentResponse(null, CloseAppointmentMessages.ATTEND_APPOINTMENT
                + LocalDateTime.now().toString()
        );
    }

    @Override
    @Transactional
    public void updateAppointmentState(Long idAppointment, State newState) {
        appointmentRepository.updateAppointmentState(idAppointment, newState);
    }
}
