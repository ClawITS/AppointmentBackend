package com.app.appointmentapp.doctor.infraestructure.entry_point.dto.mapper;

import com.app.appointmentapp.doctor.domain.model.Doctor;
import com.app.appointmentapp.doctor.infraestructure.entry_point.dto.response.DoctorFindedResponse;
import org.springframework.stereotype.Component;

@Component
public class DoctorFindedMapper {
    public DoctorFindedResponse toDoctorFindedResponse(Doctor doctor){
        return new DoctorFindedResponse.DoctorFindedResponseBuilder()
                .name(doctor.getName())
                .description(doctor.getDescription())
                .speciality(doctor.getSpeciality().getName())
                .build();
    }
}
