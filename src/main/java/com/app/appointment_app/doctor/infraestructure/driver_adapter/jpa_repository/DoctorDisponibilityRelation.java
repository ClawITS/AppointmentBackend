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
        DoctorData data = new DoctorData();
        data = getDoctorData(dataDoctor, doctor);
        if(!doctor.getDisponibilityList().isEmpty()){
            List<DisponibilityData> listDisponibilitiesData = getDisponibilityData(doctor);
            DoctorData finalData = getDoctorData(data, listDisponibilitiesData);
            finalData.setDisponibilityList(listDisponibilitiesData);
            DoctorData data1 = doctorRepository.save(finalData);
            return doctorMapper.toDoctor(data1);

        }
        return doctor;
    }

    private DoctorData getDoctorData(DoctorData data, List<DisponibilityData> listDisponibilitiesData) {
        DoctorData finalData = data;
        listDisponibilitiesData.stream()
                .forEach(
                        disponibilityData -> {
                            disponibilityData.setDoctor(finalData);
                            //  disponibilityRepository.save(disponibilityData);
                        }
                );
        return finalData;
    }

    private List<DisponibilityData> getDisponibilityData(Doctor doctor) {
        List<DisponibilityData> listDisponibilitiesData = doctor.getDisponibilityList().stream()
                .map(disponibilityMapper::toData).collect(Collectors.toList());
        return listDisponibilitiesData;
    }

    private DoctorData getDoctorData(DoctorData dataDoctor, Doctor doctor) {
        DoctorData data;
        if(doctor.getIdDoctor()!= null){
            data = dataDoctor;
        }else{
            data = doctorRepository.save(dataDoctor);
        }
        return data;
    }
}
