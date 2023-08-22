package com.app.appointment_app.doctor.infraestructure.mapper;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository.DoctorData;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorDisponibilityRelationMapper {

    public List<DisponibilityData> toDisponibilityDataList(List<Disponibility> listDisponibility){
      return listDisponibility.stream().map(
                disponibility ->
                    new DisponibilityData(disponibility.getIdDisponibility(),disponibility.getHour(),
                            null)

        ).collect(Collectors.toList());

    }
    public List<Disponibility> toDisponibilityList(List<DisponibilityData> listDisponibilityData){
        return listDisponibilityData.stream().map(
                disponibilityData ->
                        new Disponibility(disponibilityData.getIdDisponibility(),disponibilityData.getHour(),
                                null)

        ).collect(Collectors.toList());

    }
}
