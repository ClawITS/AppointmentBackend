package com.app.appointment_app.disponibility.infraestructure.adapter.db.sql.mysql.mapper;

import com.app.appointment_app.commons.domain.mappers.SpecialityCommonMapper;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.infraestructure.adapter.db.sql.mysql.entity.DisponibilityData;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.infraestructure.adapter.db.sql.mysql.entity.DoctorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  disponibility mapper
 *
 */
@Component
public class DisponibilityMapper {
    @Autowired
    private SpecialityCommonMapper specialityCommonMapper;
    public Disponibility toDisponibility(DisponibilityData disponibilityData) {
        Doctor doc = new Doctor(disponibilityData.getDoctor().getIdDoctor(),
                disponibilityData.getDoctor().getName(),
                disponibilityData.getDoctor().getDescription(), null);
        return new Disponibility(disponibilityData.getIdDisponibility(), disponibilityData.getHour(),
                doc, disponibilityData.getDisponibilityState());
    }

    public DisponibilityData toData(Disponibility disponibility) {
        return new DisponibilityData(disponibility.getIdDisponibility(), disponibility.getHour(),
                this.toDoctorData(disponibility.getDoctor()), disponibility.getDisponibilityState());
    }
    public DoctorData toDoctorData(Doctor doctor){
        return new DoctorData.DoctorDataBuilder().
                withIdDoctor(doctor.getIdDoctor())
                .withName(doctor.getName())
                .withDescription(doctor.getDescription())
                .withSpeciality(specialityCommonMapper.toSpecialityData(doctor.getSpeciality()))
                .build();

    }


}
