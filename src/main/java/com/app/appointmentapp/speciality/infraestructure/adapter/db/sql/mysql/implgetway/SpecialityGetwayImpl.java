package com.app.appointmentapp.speciality.infraestructure.adapter.db.sql.mysql.implgetway;

import com.app.appointmentapp.speciality.domain.getways.cruds.SpecialityDeleteGetway;
import com.app.appointmentapp.speciality.domain.getways.cruds.SpecialityFindAllGetway;
import com.app.appointmentapp.speciality.domain.getways.cruds.SpecialityFindByIdGetway;
import com.app.appointmentapp.speciality.domain.getways.cruds.SpecialitySaveGetway;
import com.app.appointmentapp.speciality.domain.model.Speciality;
import com.app.appointmentapp.speciality.infraestructure.adapter.db.sql.mysql.entity.SpecialityData;
import com.app.appointmentapp.speciality.infraestructure.adapter.db.sql.mysql.jpa_repository.SpecialityRepository;
import com.app.appointmentapp.speciality.infraestructure.adapter.db.sql.mysql.mapper.SpecialityMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
                .toList();
    }
    @Override
    public Speciality findById(Long id) {
        Optional<SpecialityData> data= specialityRepository.findById(id);
        if(data.isPresent()){
            return specialityMapper.toSpeciality(data.get());
        }else{
            return null;
        }

    }
    @Override
    public Speciality save(Speciality speciality) {

        return specialityMapper.
                toSpeciality(specialityRepository
                        .save(specialityMapper.toData(speciality)));
    }
}
