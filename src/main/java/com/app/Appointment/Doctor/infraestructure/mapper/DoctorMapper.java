package com.app.Appointment.Doctor.infraestructure.mapper;

import com.app.Appointment.Doctor.domain.model.Doctor;
import com.app.Appointment.Doctor.infraestructure.driver_adapter.jpa_repository.DoctorData;
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
