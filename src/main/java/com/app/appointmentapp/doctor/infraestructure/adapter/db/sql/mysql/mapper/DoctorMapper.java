package com.app.appointmentapp.doctor.infraestructure.adapter.db.sql.mysql.mapper;

import com.app.appointmentapp.commons.domain.mappers.SpecialityCommonMapper;
import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.infraestructure.adapter.db.sql.mysql.entity.DisponibilityData;
import com.app.appointmentapp.doctor.domain.model.Doctor;
import com.app.appointmentapp.doctor.infraestructure.adapter.db.sql.mysql.entity.DoctorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DoctorMapper {
    @Autowired
    private DoctorDisponibilityRelationMapper doctorDisponibilityRelationMapper;
    @Autowired
    private SpecialityCommonMapper specialityCommonMapper;
    public Doctor toDoctor(DoctorData doctorData){
        Doctor doctor = new Doctor(doctorData.getIdDoctor(),doctorData.getName(),doctorData.getDescription()
        ,null);
        return new Doctor.DoctorBuilder()
                .withIdDoctor(doctorData.getIdDoctor())
                .withName(doctorData.getName())
                .withDescription(doctorData.getDescription())
                .withDisponibilityList(doctorDisponibilityRelationMapper.toDisponibilityList(doctorData.getDisponibilityList(), doctor))
                .withSpeciality(specialityCommonMapper.toSpeciality(doctorData.getSpeciality()))
                .build();
    }

    public DoctorData toData(Doctor doctor){
        List<DisponibilityData> disponibilityData = null;
        if(doctor.getDisponibilityList() != null){
            disponibilityData =  doctor.getDisponibilityList().stream().map(this::toDisponibilityData)
                    .toList();
        }
        return new DoctorData.DoctorDataBuilder()
                .withIdDoctor(doctor.getIdDoctor())
                .withDisponibilityList(disponibilityData)
                .withDescription(doctor.getDescription())
                .withName(doctor.getName())
                .withSpeciality(specialityCommonMapper.toSpecialityData(doctor.getSpeciality()))
                .build();
    }
    public DisponibilityData toDisponibilityData(Disponibility disponibility){
        DoctorData doctorData = null;
        if (disponibility.getDoctor() != null){
            doctorData =  new DoctorData.DoctorDataBuilder()
                    .withIdDoctor(disponibility.getDoctor().getIdDoctor())
                    .withDescription(disponibility.getDoctor().getDescription())
                    .withSpeciality(specialityCommonMapper.toSpecialityData(disponibility.getDoctor().getSpeciality()))
                    .withName(disponibility.getDoctor().getName())
                    .build();
        }
        return new DisponibilityData(disponibility.getIdDisponibility(), disponibility.getHour(), doctorData
               , disponibility.getDisponibilityState());
    }
}
