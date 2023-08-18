package com.app.appointment_app.doctor.domain.useCases;

import com.app.appointment_app.doctor.domain.getways.DoctorSaveGetway;
import com.app.appointment_app.doctor.domain.model.Doctor;

public class DoctorSaveUseCase {
    private final DoctorSaveGetway doctorSaveGetway;

    public DoctorSaveUseCase(DoctorSaveGetway doctorSaveGetway) {
        this.doctorSaveGetway = doctorSaveGetway;
    }
    public Doctor saveDoctor(Doctor doctor){
        return doctorSaveGetway.saveDoctor(doctor);
    }
}
