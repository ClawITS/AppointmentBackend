package com.app.appointment_app.doctor.infraestructure.mapper;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.infraestructure.mapper.DisponibilityMapper;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository.DoctorData;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class DoctorMapper {
    @Autowired
    private DoctorDisponibilityRelationMapper doctorDisponibilityRelationMapper;
    public Doctor toDoctor(DoctorData doctorData){

        return new Doctor(doctorData.getIdDoctor(),doctorData.getName(),doctorData.getDescription(),
               doctorData.getDisponibilities().stream().map(
                       doctorDisponibilityRelationMapper::toDisponibility
               ).collect(Collectors.toList()));
    }
    public DoctorData toData(Doctor doctor){
        List<Disponibility> listDisponibilities = new ArrayList<>();
        doctor.getDisponibilities().forEach(
                disponibility -> {
                    disponibility.setDoctor(doctor);
                    listDisponibilities.add(disponibility);
                }
        );
        return new DoctorData(doctor.getIdDoctor(),doctor.getName(),doctor.getDescription(),
                listDisponibilities.stream()
                        .map(
                                doctorDisponibilityRelationMapper::toData
                        ).collect(Collectors.toList()));
    }
}
