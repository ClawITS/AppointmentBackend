package com.app.appointment_app.doctor.infraestructure.mapper;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository.DoctorData;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DoctorMapper {

    public Doctor toDoctor(DoctorData doctorData){

        return new Doctor(doctorData.getIdDoctor(),doctorData.getName(),doctorData.getDescription(),
               doctorData.getDisponibilities().stream().map(
                       disponibilityData -> new Disponibility(disponibilityData.getIdDisponibility(),
                               disponibilityData.getHour(),)
               ));
    }
    public DoctorData toData(Doctor doctor){
        DoctorBidirectionalRelationMapper doctorBidirectionalRelationMapper = new DoctorBidirectionalRelationMapper();
        return new DoctorData(doctor.getIdDoctor(),doctor.getName(),doctor.getDescription(),
                doctorBidirectionalRelationMapper.oneToManyDisponibilitiesData(doctor.getDisponibilities()));
    }
}
