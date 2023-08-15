package com.app.appointment_app.doctor.infraestructure.mapper;

import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository.DoctorData;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DoctorMapper {
    public Doctor toDoctor(DoctorData doctorData){
        return new Doctor(doctorData.getIdDoctor(),doctorData.getName(),doctorData.getDescription());
    }
    public DoctorData toData(Doctor doctor){
        return new DoctorData(doctor.getIdDoctor(),doctor.getName(),doctor.getDescription());
    }
}
