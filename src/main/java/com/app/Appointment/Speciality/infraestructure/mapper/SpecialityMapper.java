package com.app.Appointment.Speciality.infraestructure.mapper;

import com.app.Appointment.Speciality.domain.model.Speciality;
import com.app.Appointment.Speciality.infraestructure.driver_adapter.jpa_repository.SpecialityData;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
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
