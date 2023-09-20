package com.app.appointmentapp.doctor.domain.usecases.cruds;

import com.app.appointmentapp.doctor.domain.getways.cruds.DoctorFindByIdGetway;
import com.app.appointmentapp.doctor.domain.model.Doctor;

public class DoctorFindByIdUseCase {
    private final DoctorFindByIdGetway doctorFindByIdGetway;

    public DoctorFindByIdUseCase(DoctorFindByIdGetway doctorFindByIdGetway) {
        this.doctorFindByIdGetway = doctorFindByIdGetway;
    }
    public Doctor findDoctorById(Long id){
        return doctorFindByIdGetway.findById(id);
    }
}
