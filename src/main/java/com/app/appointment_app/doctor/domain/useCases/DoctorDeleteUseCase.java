package com.app.appointment_app.doctor.domain.useCases;

import com.app.appointment_app.doctor.domain.getways.DoctorDeleteGetway;

public class DoctorDeleteUseCase {
    private final DoctorDeleteGetway doctorDeleteGetway;

    public DoctorDeleteUseCase(DoctorDeleteGetway doctorDeleteGetway) {
        this.doctorDeleteGetway = doctorDeleteGetway;
    }

    public void deleteDoctorById(Long id){
        doctorDeleteGetway.deleteById(id);
    }
}
