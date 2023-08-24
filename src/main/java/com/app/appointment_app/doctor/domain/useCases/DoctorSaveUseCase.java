package com.app.appointment_app.doctor.domain.useCases;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.model.enums.DisponibilityState;
import com.app.appointment_app.doctor.domain.getways.DoctorDisponibilityRelationGetway;
import com.app.appointment_app.doctor.domain.getways.DoctorSaveGetway;
import com.app.appointment_app.doctor.domain.model.Doctor;

import java.util.List;

public class DoctorSaveUseCase {
    private final DoctorSaveGetway doctorSaveGetway;
    private final DoctorDisponibilityRelationGetway doctorDisponibilityRelation;

    public DoctorSaveUseCase(DoctorSaveGetway doctorSaveGetway, DoctorDisponibilityRelationGetway doctorDisponibilityRelation) {
        this.doctorSaveGetway = doctorSaveGetway;
        this.doctorDisponibilityRelation = doctorDisponibilityRelation;
    }

    public Doctor saveDoctor(Doctor doctor) {
        if (!doctor.getDisponibilityList().isEmpty()) {
            if (doctor.getIdDoctor() == null) {
                Doctor newDoctor = doctorSaveGetway.saveDoctor(doctor);
                List<Disponibility> disponibilityList = doctor.getDisponibilityList();
                disponibilityList.forEach(
                        disponibility -> disponibility.setDisponibilityState(DisponibilityState.AVAILABLE)
                );
                newDoctor.setDisponibilityList(disponibilityList);
                return doctorDisponibilityRelation.disponibilityRelation(newDoctor);
            }
            return doctorDisponibilityRelation.disponibilityRelation(doctor);

        }
        return doctorSaveGetway.saveDoctor(doctor);
    }
}
