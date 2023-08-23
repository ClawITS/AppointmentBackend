package com.app.appointment_app.disponibility.infraestructure.mapper;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.infraestructure.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DisponibilityMapper {

    public Disponibility toDisponibility(DisponibilityData disponibilityData){
        Doctor doc = new Doctor(disponibilityData.getDoctor().getIdDoctor(),
                disponibilityData.getDoctor().getName(),
                disponibilityData.getDoctor().getDescription(),null);
        return new Disponibility(disponibilityData.getIdDisponibility(), disponibilityData.getHour(),
                doc);
    }

    public DisponibilityData toData(Disponibility disponibility){
        return new DisponibilityData(disponibility.getIdDisponibility(), disponibility.getHour(),
                null);
    }
}
