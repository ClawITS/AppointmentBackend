package com.app.appointment_app.doctor.infraestructure.adapter.db.sql.mysql.mapper;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.infraestructure.adapter.db.sql.mysql.entity.DisponibilityData;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.infraestructure.adapter.db.sql.mysql.entity.DoctorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorMapper {
    @Autowired
    private DoctorDisponibilityRelationMapper doctorDisponibilityRelationMapper;
    public Doctor toDoctor(DoctorData doctorData){
        Doctor doctor = new Doctor(doctorData.getIdDoctor(),doctorData.getName(),doctorData.getDescription()
        ,null);
        return new Doctor(doctorData.getIdDoctor(),doctorData.getName(),doctorData.getDescription(),
                doctorDisponibilityRelationMapper.toDisponibilityList(doctorData.getDisponibilityList(), doctor));
    }
    public DoctorData toData(Doctor doctor){
        List<DisponibilityData> disponibilityData = null;
        if(doctor.getDisponibilityList() != null){
            disponibilityData =  doctor.getDisponibilityList().stream().map(this::toDisponibilityData)
                    .collect(Collectors.toList());
        }
        return new DoctorData(doctor.getIdDoctor(),doctor.getName(),doctor.getDescription(),
             disponibilityData);
    }
    public DisponibilityData toDisponibilityData(Disponibility disponibility){
        DoctorData doctorData = null;
        if (disponibility.getDoctor() != null){
            doctorData =  new DoctorData(disponibility.getDoctor().getIdDoctor(), disponibility.getDoctor().getName(),
                   disponibility.getDoctor().getDescription(), null);
        }
        return new DisponibilityData(disponibility.getIdDisponibility(), disponibility.getHour(), doctorData
               , disponibility.getDisponibilityState());
    }
}