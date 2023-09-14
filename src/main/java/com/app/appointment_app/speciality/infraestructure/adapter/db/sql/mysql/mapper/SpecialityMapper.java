package com.app.appointment_app.speciality.infraestructure.adapter.db.sql.mysql.mapper;

import com.app.appointment_app.speciality.domain.model.Speciality;
import com.app.appointment_app.speciality.infraestructure.adapter.db.sql.mysql.entity.SpecialityData;
import org.springframework.stereotype.Component;

@Component
public class SpecialityMapper {
    public Speciality toSpeciality(SpecialityData specialityData){
        return new Speciality(specialityData.getIdSpeciality(),
                specialityData.getName(), specialityData.getGrade());
    }
    public SpecialityData toData(Speciality speciality){
        return new SpecialityData(speciality.getIdSpeciality(),
                speciality.getName(), speciality.getGrade());
    }
}
