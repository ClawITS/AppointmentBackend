package com.app.appointmentapp.doctor.domain.dto.mappers;
import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.doctor.domain.dto.response.DoctorDisponibilityListResponse;
import com.app.appointmentapp.doctor.domain.model.Doctor;
import com.app.appointmentapp.doctor.domain.dto.response.DoctorResponse;

import java.util.List;

import static java.util.Objects.isNull;

public class DoctorResponseMapper {

    public DoctorResponse toDoctorResponse(Doctor doctor){
        List<DoctorDisponibilityListResponse> disponibilityList = null;
        if(!isNull(doctor.getDisponibilityList())){
            disponibilityList = newDisponibilities(doctor.getDisponibilityList());
        }
        return new DoctorResponse.DoctorResponseBuilder()
                .withName(doctor.getName())
                .withDescription(doctor.getDescription())
                .withNewDisponibilitiesHour(disponibilityList)
                .withSpeciality(doctor.getSpeciality())
                .build();
    }
    public List<DoctorDisponibilityListResponse> newDisponibilities(List<Disponibility> disponibilities){
        return disponibilities.stream().map(disponibility ->
                new DoctorDisponibilityListResponse.DoctorDisponibilityListResponseBuilder()
                        .hour(disponibility.getHour())
                        .state(disponibility.getDisponibilityState())
                        .build()
        ).toList();
    }
}
