package com.app.appointmentapp.appointment.infraestructure.adapter.db.sql.mysql.implgetway;
import com.app.appointmentapp.appointment.domain.constants.CloseAppointmentMessages;
import com.app.appointmentapp.appointment.domain.getways.business_services.CloseAppointmentGetway;
import com.app.appointmentapp.appointment.domain.getways.cruds.*;
import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.appointment.domain.model.enums.State;
import com.app.appointmentapp.appointment.domain.dto.requests.CloseAppointmentRequest;
import com.app.appointmentapp.appointment.domain.dto.responses.AppointmentPaginatorResponse;
import com.app.appointmentapp.appointment.domain.dto.responses.CloseAppointmentResponse;
import com.app.appointmentapp.appointment.domain.dto.responses.SaveAppointmentResponse;
import com.app.appointmentapp.appointment.infraestructure.adapter.db.sql.mysql.entity.AppointmentData;
import com.app.appointmentapp.appointment.infraestructure.adapter.db.sql.mysql.jpa_repository.AppointmentRepository;
import com.app.appointmentapp.appointment.infraestructure.adapter.db.sql.mysql.mapper.AppointmentMapper;
import com.app.appointmentapp.appointment.infraestructure.adapter.db.sql.mysql.mapper.SaveResponseMapper;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        return data.get().map(appointmentData -> new AppointmentPaginatorResponse(appointmentData
                        .getDisponibility().getHour(), appointmentData.getPatientData().getName(),
                        appointmentData.getDisponibility().getDoctor().getName(), appointmentData.getState(), data.getTotalPages()))
                .toList();
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll().stream()
                .map(appointmentMapper::toAppointment)
                .toList();
    }

    @Override
    public Appointment findById(Long id) {
        Optional<AppointmentData> data = appointmentRepository.findById(id);
        if (data.isPresent()) {
            return appointmentMapper.toAppointment(data.get());
        } else {
            throw new NoSuchElementException("There aren´t an appointment with this id");
        }
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
