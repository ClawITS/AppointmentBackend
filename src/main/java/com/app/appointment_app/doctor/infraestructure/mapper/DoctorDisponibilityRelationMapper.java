package com.app.appointment_app.doctor.infraestructure.mapper;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import com.app.appointment_app.doctor.domain.model.Doctor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorDisponibilityRelationMapper {

    public List<DisponibilityData> toDisponibilityDataList(List<Disponibility> listDisponibility){
      return listDisponibility.stream().map(
                disponibility ->
                    new DisponibilityData(disponibility.getIdDisponibility(),disponibility.getHour(),
                            null,disponibility.getDisponibilityState())

        ).collect(Collectors.toList());

    }
    public List<Disponibility> toDisponibilityList(List<DisponibilityData> listDisponibilityData, Doctor doctor){
        if(listDisponibilityData!=null){
            return listDisponibilityData.stream().map(
                    disponibilityData ->
                            new Disponibility(disponibilityData.getIdDisponibility(),disponibilityData.getHour(),
                                    doctor,disponibilityData.getDisponibilityState())

            ).collect(Collectors.toList());
        }
        else{
            return null;
        }


    }
}
