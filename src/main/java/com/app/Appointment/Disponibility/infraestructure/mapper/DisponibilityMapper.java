package com.app.Appointment.Disponibility.infraestructure.mapper;

import com.app.Appointment.Disponibility.domain.model.Disponibility;
import com.app.Appointment.Disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DisponibilityMapper {

    public Disponibility toDisponibility(DisponibilityData disponibilityData){
        return new Disponibility(disponibilityData.getIdDisponibility(), disponibilityData.getHour());
    }

    public DisponibilityData toData(Disponibility disponibility){
        return new DisponibilityData(disponibility.getIdDisponibility(), disponibility.getHour());
    }
}
