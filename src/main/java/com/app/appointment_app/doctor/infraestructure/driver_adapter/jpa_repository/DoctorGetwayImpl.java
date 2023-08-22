package com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository;
import com.app.appointment_app.disponibility.infraestructure.driver_adapter.s3_repository.DisponibilityRepository;
import com.app.appointment_app.disponibility.infraestructure.mapper.DisponibilityMapper;
import com.app.appointment_app.doctor.domain.getways.DoctorDeleteGetway;
import com.app.appointment_app.doctor.domain.getways.DoctorFindAllGetway;
import com.app.appointment_app.doctor.domain.getways.DoctorFindByIdGetway;
import com.app.appointment_app.doctor.domain.getways.DoctorSaveGetway;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.infraestructure.driver_adapter.s3_repository.DoctorRepository;
import com.app.appointment_app.doctor.infraestructure.mapper.DoctorMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;


@Repository
public class DoctorGetwayImpl implements DoctorFindAllGetway, DoctorDeleteGetway, DoctorSaveGetway,
        DoctorFindByIdGetway {
    private final DoctorRepository doctorRepository;
    private final DisponibilityRepository disponibilityRepository;
    private final DisponibilityMapper disponibilityMapper;
    private final DoctorDisponibilityRelation doctorDisponibilityRelationClass;
    private final DoctorMapper doctorMapper;

    public DoctorGetwayImpl(DoctorRepository doctorRepository, DisponibilityRepository disponibilityRepository, DisponibilityMapper disponibilityMapper, DoctorDisponibilityRelation doctorDisponibilityRelationClass, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.disponibilityRepository = disponibilityRepository;
        this.disponibilityMapper = disponibilityMapper;
        this.doctorDisponibilityRelationClass = doctorDisponibilityRelationClass;
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

        return doctorDisponibilityRelationClass.doctorDisponibilityRelation(dataDoctor, doctor);
    }
}
