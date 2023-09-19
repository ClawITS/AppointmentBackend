package com.app.appointmentapp.speciality.domain.usecases.cruds;

import com.app.appointmentapp.speciality.domain.getways.cruds.SpecialityFindByIdGetway;
import com.app.appointmentapp.speciality.domain.model.Speciality;

public class SpecialityFindByIdUseCase {
    private final SpecialityFindByIdGetway specialityFindByIdGetway;

    public SpecialityFindByIdUseCase(SpecialityFindByIdGetway specialityFindByIdGetway) {
        this.specialityFindByIdGetway = specialityFindByIdGetway;
    }

    public Speciality findSpecialityById(Long id){
        return specialityFindByIdGetway.findById(id);
    }
}
