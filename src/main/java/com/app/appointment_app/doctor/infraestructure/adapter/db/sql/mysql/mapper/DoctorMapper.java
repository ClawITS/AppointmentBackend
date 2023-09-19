package com.app.appointment_app.doctor.infraestructure.adapter.db.sql.mysql.mapper;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.infraestructure.adapter.db.sql.mysql.entity.DisponibilityData;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.infraestructure.adapter.db.sql.mysql.entity.DoctorData;
import com.app.appointment_app.speciality.domain.model.Speciality;
import com.app.appointment_app.speciality.infraestructure.adapter.db.sql.mysql.entity.SpecialityData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Component
public class DoctorMapper {
    @Autowired
    private DoctorDisponibilityRelationMapper doctorDisponibilityRelationMapper;
    public Doctor toDoctor(DoctorData doctorData){
        Doctor doctor = new Doctor(doctorData.getIdDoctor(),doctorData.getName(),doctorData.getDescription()
        ,null);
        return new Doctor.DoctorBuilder()
                .withIdDoctor(doctorData.getIdDoctor())
                .withName(doctorData.getName())
                .withDescription(doctorData.getDescription())
                .withDisponibilityList(doctorDisponibilityRelationMapper.toDisponibilityList(doctorData.getDisponibilityList(), doctor))
                .withSpeciality(toSpeciality(doctorData.getSpeciality()))
                .build();
    }
    public Speciality toSpeciality(SpecialityData specialityData){
        if(isNull(specialityData)){
            return null;
        }
        return new Speciality(specialityData.getIdSpeciality(),specialityData.getName(),
                specialityData.getGrade());
    }
    public SpecialityData toSpecialityData(Speciality speciality){
        if(isNull(speciality)){
            return null;
        }
        return new SpecialityData(speciality.getIdSpeciality(),speciality.getName(),
                speciality.getGrade());
    }
    public DoctorData toData(Doctor doctor){
        List<DisponibilityData> disponibilityData = null;
        if(doctor.getDisponibilityList() != null){
            disponibilityData =  doctor.getDisponibilityList().stream().map(this::toDisponibilityData)
                    .collect(Collectors.toList());
        }
        return new DoctorData.DoctorDataBuilder()
                .withIdDoctor(doctor.getIdDoctor())
                .withDisponibilityList(disponibilityData)
                .withDescription(doctor.getDescription())
                .withName(doctor.getName())
                .build();
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
