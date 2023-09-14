package com.app.appointment_app.doctor.domain.useCases.cruds;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.model.enums.DisponibilityState;
import com.app.appointment_app.doctor.domain.getways.cruds.DoctorSaveGetway;
import com.app.appointment_app.doctor.domain.model.Doctor;

import java.util.List;

public class DoctorSaveUseCase {
    private final DoctorSaveGetway doctorSaveGetway;

    public DoctorSaveUseCase(DoctorSaveGetway doctorSaveGetway) {
        this.doctorSaveGetway = doctorSaveGetway;
    }

    public Doctor saveDoctor(Doctor doctor) {
        if (!doctor.getDisponibilityList().isEmpty()) {
            List<Disponibility> listDisponibilities = doctor.getDisponibilityList();
            Doctor doctor1 = saveDoctorWithoutList(doctor);
            setListDisponibilitiesWithDoctorSavedAndDoctorWithDisponibilityList(listDisponibilities, doctor1);
            return doctorSaveGetway.saveDoctor(doctor1);}
        return doctorSaveGetway.saveDoctor(doctor);
    }

    private void setListDisponibilitiesWithDoctorSavedAndDoctorWithDisponibilityList(List<Disponibility> listDisponibilities, Doctor doctor1) {
        listDisponibilities.forEach(disponibility ->{
                    disponibility.setDoctor(doctor1);
                    disponibility.setDisponibilityState(DisponibilityState.AVAILABLE);
                });
        doctor1.setDisponibilityList(listDisponibilities);
    }

    private Doctor saveDoctorWithoutList(Doctor doctor) {
        doctor.setDisponibilityList(null);
        Doctor doctor1 =doctorSaveGetway.saveDoctor(doctor);
        return doctor1;
    }
}
