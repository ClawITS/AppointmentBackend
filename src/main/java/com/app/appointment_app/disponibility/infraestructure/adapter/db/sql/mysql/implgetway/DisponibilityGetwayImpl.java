package com.app.appointment_app.disponibility.infraestructure.adapter.db.sql.mysql.implgetway;

import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilityDeleteByIdGetway;
import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilityFindAllGetway;
import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilityFindByIdGetway;
import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilitySaveGetway;
import com.app.appointment_app.disponibility.domain.getways.filters.DisponibilityFilterByDoctorAndHourGetway;
import com.app.appointment_app.disponibility.domain.getways.filters.DisponibilityFilterByHourGetway;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.requests.DisponibilityFilterByDoctorAndHourRequest;
import com.app.appointment_app.disponibility.domain.requests.DisponibilityFilterByHourRequest;
import com.app.appointment_app.disponibility.infraestructure.adapter.db.sql.mysql.entity.DisponibilityData;
import com.app.appointment_app.disponibility.infraestructure.adapter.db.sql.mysql.jpa_repository.DisponibilityRepository;
import com.app.appointment_app.disponibility.infraestructure.adapter.db.sql.mysql.mapper.DisponibilityMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DisponibilityGetwayImpl implements DisponibilitySaveGetway,
        DisponibilityFindAllGetway, DisponibilityFindByIdGetway, DisponibilityDeleteByIdGetway,
        DisponibilityFilterByHourGetway, DisponibilityFilterByDoctorAndHourGetway {
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
        DisponibilityData disponibilityData = disponibilityMapper.toData(disponibility);
     /*   if(disponibility.getPendingReschedule() != null && disponibility.getPendingReschedule().getIdPendingHour()
        == null){
            disponibilityData.setPendingReschedule(new PendingHourData(null
                    , disponibility.getPendingReschedule().getNewHour()));
        }
        disponibilityRepository.save(disponibilityData);*/
        return disponibilityMapper.toDisponibility(disponibilityData);
    }

    @Override
    public List<Disponibility> filterByHour(DisponibilityFilterByHourRequest doctorFilterByHourRequest) {
        return disponibilityRepository.findByHourRange(doctorFilterByHourRequest.getStartDate()
                ,doctorFilterByHourRequest.getEndDate()).stream().map(
                        disponibilityMapper::toDisponibility
        ).collect(Collectors.toList());
    }

    @Override
    public List<Disponibility> filterByDoctorAndHour(DisponibilityFilterByDoctorAndHourRequest disponibilityFilterByDoctorAndHourRequest) {
        return disponibilityRepository.findByDoctorIdAndHourRange(
                disponibilityFilterByDoctorAndHourRequest.getDoctorId(),disponibilityFilterByDoctorAndHourRequest.getStartDate(),
                disponibilityFilterByDoctorAndHourRequest.getEndDate()
        ).stream().map(
                disponibilityMapper::toDisponibility
        ).collect(Collectors.toList());
    }
}