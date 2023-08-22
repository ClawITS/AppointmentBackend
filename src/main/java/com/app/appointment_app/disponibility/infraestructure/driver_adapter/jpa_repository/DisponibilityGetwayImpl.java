package com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.disponibility.domain.getways.DisponibilityDeleteByIdGetway;
import com.app.appointment_app.disponibility.domain.getways.DisponibilityFindAllGetway;
import com.app.appointment_app.disponibility.domain.getways.DisponibilityFindByIdGetway;
import com.app.appointment_app.disponibility.domain.getways.DisponibilitySaveGetway;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.infraestructure.driver_adapter.s3_repository.DisponibilityRepository;
import com.app.appointment_app.disponibility.infraestructure.mapper.DisponibilityMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class DisponibilityGetwayImpl implements DisponibilitySaveGetway,
        DisponibilityFindAllGetway, DisponibilityFindByIdGetway, DisponibilityDeleteByIdGetway {
    private final DisponibilityRepository disponibilityRepository;
    private final DisponibilityMapper disponibilityMapper;

    public DisponibilityGetwayImpl(DisponibilityRepository disponibilityRepository, DisponibilityMapper disponibilityMapper) {
        this.disponibilityRepository = disponibilityRepository;
        this.disponibilityMapper = disponibilityMapper;
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

        return null;
    }
}
