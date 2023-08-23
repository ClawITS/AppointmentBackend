package com.app.appointment_app.doctor_ranking.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.doctor_ranking.domain.getways.DoctorRankingDeleteGetway;
import com.app.appointment_app.doctor_ranking.domain.getways.DoctorRankingFindAllGetway;
import com.app.appointment_app.doctor_ranking.domain.getways.DoctorRankingFindByIdGetway;
import com.app.appointment_app.doctor_ranking.domain.getways.DoctorRankingSaveGetway;
import com.app.appointment_app.doctor_ranking.domain.model.DoctorRanking;
import com.app.appointment_app.doctor_ranking.infraestructure.driver_adapter.s3_repository.DoctorRankingRepository;
import com.app.appointment_app.doctor_ranking.infraestructure.mapper.DoctorRankingMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DoctorRankingGetwayImpl implements DoctorRankingSaveGetway, DoctorRankingDeleteGetway, DoctorRankingFindByIdGetway, DoctorRankingFindAllGetway {
    private final DoctorRankingRepository doctorRankingRepository;
    private final DoctorRankingMapper doctorRankingMapper;

    public DoctorRankingGetwayImpl(DoctorRankingRepository doctorRankingRepository, DoctorRankingMapper doctorRankingMapper) {
        this.doctorRankingRepository = doctorRankingRepository;
        this.doctorRankingMapper = doctorRankingMapper;
    }

    @Override
    public void deleteById(Long id) {
        doctorRankingRepository.deleteById(id);
    }

    @Override
    public Page<DoctorRanking> findAllPaginator(int numberPage) {
        int pageSize = 10;
        PageRequest page = PageRequest.of(numberPage, pageSize);
        Page<DoctorRankingData> data = doctorRankingRepository.findAll(page);
        return data.map(doctorRankingMapper::toDoctorRanking);
    }

    @Override
    public List<DoctorRanking> findAll() {
        return doctorRankingRepository.findAll().stream()
                .map(doctorRankingMapper::toDoctorRanking)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorRanking findById(Long id) {
        Optional<DoctorRankingData> data = doctorRankingRepository.findById(id);
        return doctorRankingMapper.toDoctorRanking(data.get());
    }

    @Override
    public DoctorRanking save(DoctorRanking doctorRanking) {
        return doctorRankingMapper
                .toDoctorRanking(doctorRankingRepository.save(doctorRankingMapper.toData(doctorRanking)));
    }
}
