package com.app.appointmentapp.doctor.domain.usecases.helpers;

import com.app.appointmentapp.doctor.domain.exceptions.DoctorException;
import com.app.appointmentapp.doctor.domain.model.Doctor;
import com.app.appointmentapp.speciality.domain.getways.cruds.SpecialityFindByIdGetway;
import com.app.appointmentapp.speciality.domain.model.Speciality;

public class DoctorSaveHelper {
    private final SpecialityFindByIdGetway specialityFindByIdGetway;

    public DoctorSaveHelper(SpecialityFindByIdGetway specialityFindByIdGetway) {
        this.specialityFindByIdGetway = specialityFindByIdGetway;
    }
    public void chargeDoctorWithSpeciality(Doctor doctor) throws DoctorException {
        Speciality foundSpeciality = specialityFindByIdGetway.findById(doctor.getSpeciality().getIdSpeciality());
        if (foundSpeciality == null) {
            throw new DoctorException("Speciality not found");
        }
        doctor.setSpeciality(foundSpeciality);
    }

}
