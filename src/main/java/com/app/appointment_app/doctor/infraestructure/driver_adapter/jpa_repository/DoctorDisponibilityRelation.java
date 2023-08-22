package com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import com.app.appointment_app.disponibility.infraestructure.mapper.DisponibilityMapper;
import com.app.appointment_app.doctor.domain.getways.DoctorDisponibilityRelationGetway;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.infraestructure.driver_adapter.s3_repository.DoctorRepository;
import com.app.appointment_app.doctor.infraestructure.mapper.DoctorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorDisponibilityRelation implements DoctorDisponibilityRelationGetway {
    private final DisponibilityMapper disponibilityMapper;
    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;

    public DoctorDisponibilityRelation(DisponibilityMapper disponibilityMapper, DoctorMapper doctorMapper, DoctorRepository doctorRepository) {
        this.disponibilityMapper = disponibilityMapper;
        this.doctorMapper = doctorMapper;
        this.doctorRepository = doctorRepository;
    }
    @Override
    public Doctor disponibilityRelation(Doctor doctor) {
        DoctorData dataDoctor = doctorMapper.toData(doctor);
        List<DisponibilityData> listDisponibilitiesData = getDisponibilityToData(doctor);
        putDoctorIntoDisponibilityData(dataDoctor, listDisponibilitiesData);
        dataDoctor.setDisponibilityList(listDisponibilitiesData);
        return doctorMapper.toDoctor(doctorRepository.save(dataDoctor));
    }

    private void putDoctorIntoDisponibilityData(DoctorData data, List<DisponibilityData> listDisponibilitiesData) {
        listDisponibilitiesData.stream()
                .forEach(
                        disponibilityData -> {
                            disponibilityData.setDoctor(data);
                        }
                );
    }

    private List<DisponibilityData> getDisponibilityToData(Doctor doctor) {
        return doctor.getDisponibilityList().stream()
                .map(disponibilityMapper::toData).collect(Collectors.toList());
    }



}
