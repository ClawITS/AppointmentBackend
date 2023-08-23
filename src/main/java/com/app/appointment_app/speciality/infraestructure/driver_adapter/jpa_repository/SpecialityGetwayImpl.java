package com.app.appointment_app.speciality.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.speciality.domain.getways.SpecialityDeleteGetway;
import com.app.appointment_app.speciality.domain.getways.SpecialityFindAllGetway;
import com.app.appointment_app.speciality.domain.getways.SpecialityFindByIdGetway;
import com.app.appointment_app.speciality.domain.getways.SpecialitySaveGetway;
import com.app.appointment_app.speciality.domain.model.Speciality;
import com.app.appointment_app.speciality.infraestructure.driver_adapter.s3_repository.SpecialityRepository;
import com.app.appointment_app.speciality.infraestructure.mapper.SpecialityMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SpecialityGetwayImpl implements SpecialityFindAllGetway, SpecialitySaveGetway, SpecialityDeleteGetway,
        SpecialityFindByIdGetway {
    private final SpecialityRepository specialityRepository;
    private final SpecialityMapper specialityMapper;

    public SpecialityGetwayImpl(SpecialityRepository specialityRepository, SpecialityMapper specialityMapper) {
        this.specialityRepository = specialityRepository;
        this.specialityMapper = specialityMapper;
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }

    @Override
    public Page<Speciality> findAllPaginator(int numberPage) {
        int pageSize = 10;
        PageRequest page= PageRequest.of(numberPage, pageSize);
        Page<SpecialityData> data = specialityRepository.findAll(page);
        return data.map(specialityMapper::toSpeciality);
    }

    @Override
    public List<Speciality> findAll() {
        return specialityRepository.findAll().stream()
                .map(specialityMapper::toSpeciality)
                .collect(Collectors.toList());
    }
    @Override
    public Speciality findById(Long id) {
        Optional<SpecialityData> data= specialityRepository.findById(id);
        return specialityMapper.toSpeciality(data.get());
    }
    @Override
    public Speciality save(Speciality speciality) {

        return specialityMapper.
                toSpeciality(specialityRepository
                        .save(specialityMapper.toData(speciality)));
    }
}
