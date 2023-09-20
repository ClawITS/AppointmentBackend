package com.app.appointmentapp.doctor.domain.usecases.cruds;

import com.app.appointmentapp.doctor.domain.getways.cruds.DoctorDeleteGetway;

public class DoctorDeleteUseCase {
    private final DoctorDeleteGetway doctorDeleteGetway;

    public DoctorDeleteUseCase(DoctorDeleteGetway doctorDeleteGetway) {
        this.doctorDeleteGetway = doctorDeleteGetway;
    }

    public void deleteDoctorById(Long id){
        doctorDeleteGetway.deleteById(id);
    }
}
