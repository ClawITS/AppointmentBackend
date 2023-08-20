package com.app.appointment_app.disponibility.infraestructure.mapper;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import com.app.appointment_app.doctor.infraestructure.mapper.DoctorMapper;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DisponibilityMapper {
    @Autowired
    private DoctorMapper doctorMapper;
    public Disponibility toDisponibility(DisponibilityData disponibilityData){
        return new Disponibility(disponibilityData.getIdDisponibility(), disponibilityData.getHour(),
                doctorMapper.toDoctor(disponibilityData.getDoctor()));
    }

    public DisponibilityData toData(Disponibility disponibility){
        return new DisponibilityData(disponibility.getIdDisponibility(), disponibility.getHour(),
                doctorMapper.toData(disponibility.getDoctor()));
    }
}
