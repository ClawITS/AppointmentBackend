package com.app.appointment_app.doctor.domain.useCases.cruds;

import com.app.appointment_app.doctor.domain.getways.cruds.DoctorFindByIdGetway;
import com.app.appointment_app.doctor.domain.model.Doctor;

public class DoctorFindByIdUseCase {
    private final DoctorFindByIdGetway doctorFindByIdGetway;

    public DoctorFindByIdUseCase(DoctorFindByIdGetway doctorFindByIdGetway) {
        this.doctorFindByIdGetway = doctorFindByIdGetway;
    }
    public Doctor findDoctorById(Long id){
        return doctorFindByIdGetway.findById(id);
    }
}
