package com.app.appointmentapp.doctor.domain.usecases.helpers;

import com.app.appointmentapp.doctor.domain.model.Doctor;
import com.app.appointmentapp.speciality.domain.getways.cruds.SpecialityFindByIdGetway;

public class DoctorSaveHelper {
    private final SpecialityFindByIdGetway specialityFindByIdGetway;

    public DoctorSaveHelper(SpecialityFindByIdGetway specialityFindByIdGetway) {
        this.specialityFindByIdGetway = specialityFindByIdGetway;
    }
    public void chargeDoctorWithSpeciality(Doctor doctor){
        doctor.setSpeciality(specialityFindByIdGetway
                .findById(doctor.getSpeciality().getIdSpeciality()));
    }
}
