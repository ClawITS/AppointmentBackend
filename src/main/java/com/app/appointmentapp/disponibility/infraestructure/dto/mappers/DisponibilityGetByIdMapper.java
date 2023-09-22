package com.app.appointmentapp.disponibility.infraestructure.dto.mappers;

import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.infraestructure.dto.DisponibilityGetByIdResponse;
import com.app.appointmentapp.disponibility.infraestructure.dto.DoctorDisponibilityResponse;
import com.app.appointmentapp.doctor.domain.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DisponibilityGetByIdMapper {

    public DisponibilityGetByIdResponse toDisponibilityResponse(Disponibility disponibility){
       return new DisponibilityGetByIdResponse.DisponibilityGetByIdResponseBuilder()
               .idDisponibility(disponibility.getIdDisponibility())
               .hour(disponibility.getHour())
               .doctor(toDoctorDisponibilityResponse(disponibility.getDoctor()))
               .build();
    }
    public DoctorDisponibilityResponse toDoctorDisponibilityResponse(Doctor doctor){
        String name=null;
        if(doctor.getSpeciality()!=null){
            name = doctor.getSpeciality().getName();
        }
        return new DoctorDisponibilityResponse.DoctorDisponibilityResponseBuilder()
                .id(doctor.getIdDoctor())
                .name(doctor.getName())
                .speciality(name)
                .build();
    }
}
