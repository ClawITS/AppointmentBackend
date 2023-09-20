package com.app.appointmentapp.speciality.infraestructure.adapter.db.sql.mysql.mapper;

import com.app.appointmentapp.speciality.domain.model.Speciality;
import com.app.appointmentapp.speciality.infraestructure.adapter.db.sql.mysql.entity.SpecialityData;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class SpecialityMapper {
    public Speciality toSpeciality(SpecialityData specialityData){
        if(isNull(specialityData)){
            return null;
        }
        return new Speciality.SpecialityBuilder()
                .idSpeciality(specialityData.getIdSpeciality())
                .name(specialityData.getName())
                .grade(specialityData.getGrade())
                .build();
    }
    public SpecialityData toData(Speciality speciality){
        if(isNull(speciality)){
            return null;
        }
        return new SpecialityData.SpecialityDataBuilder()
                .idSpeciality(speciality.getIdSpeciality())
                .name(speciality.getName())
                .grade(speciality.getGrade())
                .build();
    }
}
