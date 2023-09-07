package com.app.appointment_app.speciality.domain.usecases.cruds;

import com.app.appointment_app.speciality.domain.getways.cruds.SpecialityFindByIdGetway;
import com.app.appointment_app.speciality.domain.model.Speciality;

public class SpecialityFindByIdUseCase {
    private final SpecialityFindByIdGetway specialityFindByIdGetway;

    public SpecialityFindByIdUseCase(SpecialityFindByIdGetway specialityFindByIdGetway) {
        this.specialityFindByIdGetway = specialityFindByIdGetway;
    }

    public Speciality findSpecialityById(Long id){
        return specialityFindByIdGetway.findById(id);
    }
}