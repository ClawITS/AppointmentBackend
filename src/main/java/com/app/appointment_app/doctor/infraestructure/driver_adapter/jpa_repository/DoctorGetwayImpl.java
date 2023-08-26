package com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository;
import com.app.appointment_app.appointment.domain.getways.AppointmentSaveGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository.AppointmentGetwayImpl;
import com.app.appointment_app.doctor.domain.getways.*;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.infraestructure.driver_adapter.s3_repository.DoctorRepository;
import com.app.appointment_app.doctor.infraestructure.mapper.DoctorMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;


@Repository
public class DoctorGetwayImpl implements DoctorFindAllGetway, DoctorDeleteGetway, DoctorSaveGetway,
        DoctorFindByIdGetway, RescheduleAppointmentGetyaw {
    private final DoctorRepository doctorRepository;
    private final AppointmentSaveGetway appointmentSaveGetway;
    private final DoctorMapper doctorMapper;

    public DoctorGetwayImpl(DoctorRepository doctorRepository, AppointmentSaveGetway appointmentSaveGetway, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.appointmentSaveGetway = appointmentSaveGetway;
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
        return doctorMapper.toDoctor(doctorRepository.save(dataDoctor));
    }

    @Override
    public Appointment rescheduleAppointment(Appointment appointment) {
        return appointmentSaveGetway.save(appointment);
    }
}
