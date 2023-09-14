package com.app.appointment_app.speciality.domain.usecases.cruds;

import com.app.appointment_app.speciality.domain.getways.cruds.SpecialityDeleteGetway;

public class SpecialityDeleteUseCase {
    private final SpecialityDeleteGetway specialityDeleteGetway;

    public SpecialityDeleteUseCase(SpecialityDeleteGetway specialityDeleteGetway) {
        this.specialityDeleteGetway = specialityDeleteGetway;
    }

    public void deleteSpecialityById(Long id){
        specialityDeleteGetway.deleteById(id);
    }
}
