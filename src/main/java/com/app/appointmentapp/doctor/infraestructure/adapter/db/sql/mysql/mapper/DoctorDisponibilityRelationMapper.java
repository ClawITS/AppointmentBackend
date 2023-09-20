package com.app.appointmentapp.doctor.infraestructure.adapter.db.sql.mysql.mapper;

import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.infraestructure.adapter.db.sql.mysql.entity.DisponibilityData;
import com.app.appointmentapp.doctor.domain.model.Doctor;
import java.util.Collections;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorDisponibilityRelationMapper {


    public List<Disponibility> toDisponibilityList(List<DisponibilityData> listDisponibilityData, Doctor doctor){
        if(listDisponibilityData!=null){
            return listDisponibilityData.stream().map(
                    disponibilityData ->
                            new Disponibility(disponibilityData.getIdDisponibility(),disponibilityData.getHour(),
                                    doctor,disponibilityData.getDisponibilityState())

            ).toList();
        }
        else{
            return Collections.emptyList();
        }


    }
}
