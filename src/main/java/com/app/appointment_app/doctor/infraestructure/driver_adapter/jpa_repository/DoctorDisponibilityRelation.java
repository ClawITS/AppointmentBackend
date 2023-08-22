package com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import com.app.appointment_app.disponibility.infraestructure.mapper.DisponibilityMapper;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.infraestructure.driver_adapter.s3_repository.DoctorRepository;
import com.app.appointment_app.doctor.infraestructure.mapper.DoctorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorDisponibilityRelation {
    private final DisponibilityMapper disponibilityMapper;
    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;

    public DoctorDisponibilityRelation(DisponibilityMapper disponibilityMapper, DoctorMapper doctorMapper, DoctorRepository doctorRepository) {
        this.disponibilityMapper = disponibilityMapper;
        this.doctorMapper = doctorMapper;
        this.doctorRepository = doctorRepository;
    }

    public Doctor doctorDisponibilityRelation(DoctorData dataDoctor, Doctor doctor){
        DoctorData dataDoctorSave = ifDoctorExistUpdate(dataDoctor, doctor);
        if(!doctor.getDisponibilityList().isEmpty()){
            List<DisponibilityData> listDisponibilitiesData = getDisponibilityToData(doctor);
            putDoctorIntoDisponibilityData(dataDoctorSave, listDisponibilitiesData);
            dataDoctorSave.setDisponibilityList(listDisponibilitiesData);
            return doctorMapper.toDoctor(doctorRepository.save(dataDoctorSave));

        }
        return doctor;
    }

    private void putDoctorIntoDisponibilityData(DoctorData data, List<DisponibilityData> listDisponibilitiesData) {
        listDisponibilitiesData.stream()
                .forEach(
                        disponibilityData -> {
                            disponibilityData.setDoctor(data);
                            //  disponibilityRepository.save(disponibilityData);
                        }
                );
    }

    private List<DisponibilityData> getDisponibilityToData(Doctor doctor) {
        return doctor.getDisponibilityList().stream()
                .map(disponibilityMapper::toData).collect(Collectors.toList());
    }

    private DoctorData ifDoctorExistUpdate(DoctorData dataDoctor, Doctor doctor) {
        DoctorData data;
        if(doctor.getIdDoctor()!= null){
            data = dataDoctor;
        }else{
            data = doctorRepository.save(dataDoctor);
        }
        return data;
    }
}
