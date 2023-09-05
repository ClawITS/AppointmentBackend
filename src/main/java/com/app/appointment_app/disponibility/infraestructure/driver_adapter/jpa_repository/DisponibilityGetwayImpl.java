package com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilityDeleteByIdGetway;
import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilityFindAllGetway;
import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilityFindByIdGetway;
import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilitySaveGetway;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.infraestructure.driver_adapter.s3_repository.DisponibilityRepository;
import com.app.appointment_app.disponibility.infraestructure.mapper.DisponibilityMapper;
import com.app.appointment_app.doctor.infraestructure.driver_adapter.s3_repository.DoctorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class DisponibilityGetwayImpl implements DisponibilitySaveGetway,
        DisponibilityFindAllGetway, DisponibilityFindByIdGetway, DisponibilityDeleteByIdGetway {
    private final DisponibilityRepository disponibilityRepository;
    private final DisponibilityMapper disponibilityMapper;
    private final DoctorRepository doctorRepository;
    public DisponibilityGetwayImpl(DisponibilityRepository disponibilityRepository, DisponibilityMapper disponibilityMapper, DoctorRepository doctorRepository) {
        this.disponibilityRepository = disponibilityRepository;
        this.disponibilityMapper = disponibilityMapper;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void deleteById(Long id) {
        disponibilityRepository.deleteById(id);
    }

    @Override
    public Page<Disponibility> findAllDisponibilitiesPage(int numberPage) {
        int pageSize = 10;
        PageRequest page= PageRequest.of(numberPage, pageSize);
        return disponibilityRepository.findAll(page)
                .map(disponibilityMapper::toDisponibility);
    }

    @Override
    public Disponibility findById(Long id) {
        return disponibilityMapper.toDisponibility(disponibilityRepository
                .findById(id).get());
    }

    @Override
    public Disponibility save(Disponibility disponibility) {
      // Optional<DoctorData> doctorData = doctorRepository.findById(disponibility.getDoctor().getIdDoctor());
        DisponibilityData disponibilityData = disponibilityMapper.toData(disponibility);
       //disponibilityData.setDoctor(doctorData.get());
        disponibilityRepository.save(disponibilityData);
        return disponibilityMapper.toDisponibility(disponibilityData);
    }
}
