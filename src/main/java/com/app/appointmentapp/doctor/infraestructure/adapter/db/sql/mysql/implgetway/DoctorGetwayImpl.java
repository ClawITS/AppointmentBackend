package com.app.appointmentapp.doctor.infraestructure.adapter.db.sql.mysql.implgetway;
import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.doctor.domain.constants.DoctorResponseMessages;
import com.app.appointmentapp.doctor.domain.getways.business_services.AcceptPatientReschedulingGetway;
import com.app.appointmentapp.doctor.domain.getways.business_services.RescheduleAppointmentGetway;
import com.app.appointmentapp.doctor.domain.getways.cruds.DoctorDeleteGetway;
import com.app.appointmentapp.doctor.domain.getways.cruds.DoctorFindAllGetway;
import com.app.appointmentapp.doctor.domain.getways.cruds.DoctorFindByIdGetway;
import com.app.appointmentapp.doctor.domain.getways.cruds.DoctorSaveGetway;
import com.app.appointmentapp.doctor.domain.model.Doctor;
import com.app.appointmentapp.doctor.domain.dto.requests.RescheduleAppointmentRequest;
import com.app.appointmentapp.doctor.domain.dto.response.AcceptPatientReschedulingResponse;
import com.app.appointmentapp.doctor.domain.dto.response.RescheduleAppointmentResponse;
import com.app.appointmentapp.doctor.infraestructure.adapter.db.sql.mysql.entity.DoctorData;
import com.app.appointmentapp.doctor.infraestructure.adapter.db.sql.mysql.jpa_repository.DoctorRepository;
import com.app.appointmentapp.doctor.infraestructure.adapter.db.sql.mysql.mapper.DoctorMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;


@Repository
public class DoctorGetwayImpl implements DoctorFindAllGetway, DoctorDeleteGetway, DoctorSaveGetway,
        DoctorFindByIdGetway, RescheduleAppointmentGetway, AcceptPatientReschedulingGetway {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorGetwayImpl(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public void deleteById(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Page<Doctor> findAllPaginator(int numberPage) {
        int pageSize = 10;
        PageRequest page= PageRequest.of(numberPage, pageSize);
        return doctorRepository.findAll(page)
                .map(doctorMapper::toDoctor);
    }

    @Override
    public Doctor findById(Long id) {
        return doctorMapper.toDoctor(doctorRepository.findById(id).get());
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
       DoctorData dataDoctor = doctorMapper.toData(doctor);
        return doctorMapper
                .toDoctor(doctorRepository.save(dataDoctor));
    }


    @Override
    public RescheduleAppointmentResponse rescheduleAppointment(RescheduleAppointmentRequest rescheduleAppointmentRequest) {
        return new RescheduleAppointmentResponse(rescheduleAppointmentRequest.getReschuldeHour(),rescheduleAppointmentRequest
                .getActualHour(), DoctorResponseMessages.RESCHEDULE_APPOINTMENT +
                rescheduleAppointmentRequest.getPatientName());
    }

    @Override
    public AcceptPatientReschedulingResponse acceptPatientRescheduling(Appointment appointment) {
        return new AcceptPatientReschedulingResponse(DoctorResponseMessages.ACCEPT_PATIENT_RESCHEDULE);
    }
}
