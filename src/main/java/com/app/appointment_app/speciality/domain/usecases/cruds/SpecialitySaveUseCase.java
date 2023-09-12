package com.app.appointment_app.speciality.domain.usecases.cruds;
import com.app.appointment_app.speciality.domain.getways.cruds.SpecialitySaveGetway;
import com.app.appointment_app.speciality.domain.model.Speciality;
public class SpecialitySaveUseCase {
    private final SpecialitySaveGetway specialitySaveGetway;
    public SpecialitySaveUseCase(SpecialitySaveGetway specialitySaveGetway) {
        this.specialitySaveGetway = specialitySaveGetway;
    }

    public Speciality saveSpeciality(Speciality speciality){
            return specialitySaveGetway.save(speciality);
    }

}
