package com.app.appointment_app.doctor.infraestructure.mapper;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository.DoctorData;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class DoctorDisponibilityRelationMapper {


    public Disponibility toDisponibility(DisponibilityData disponibilityData){

        return new Disponibility(disponibilityData.getIdDisponibility(), disponibilityData.getHour(),
                null);
    }

    public DisponibilityData toData(Disponibility disponibility){
        DoctorData doctorData = new DoctorData(disponibility.getDoctor().getIdDoctor(),
                disponibility.getDoctor().getName(),disponibility.getDoctor().getDescription(),null);
        return new DisponibilityData(disponibility.getIdDisponibility(), disponibility.getHour(),
                doctorData);
    }
    public List<Disponibility> doctorDisponibilities(List<DisponibilityData> disponibilityDataList){

        return disponibilityDataList.stream().map(this::toDisponibility).collect(Collectors.toList());
    }
    public List<DisponibilityData> doctorDisponibilitiesData(List<Disponibility> disponibilityList){

        return disponibilityList.stream().map(this::toData).collect(Collectors.toList());
    }
}
