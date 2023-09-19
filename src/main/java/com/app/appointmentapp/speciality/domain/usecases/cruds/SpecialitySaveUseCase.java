package com.app.appointmentapp.speciality.domain.usecases.cruds;
import com.app.appointmentapp.speciality.domain.getways.cruds.SpecialitySaveGetway;
import com.app.appointmentapp.speciality.domain.model.Speciality;
public class SpecialitySaveUseCase {
    private final SpecialitySaveGetway specialitySaveGetway;
    public SpecialitySaveUseCase(SpecialitySaveGetway specialitySaveGetway) {
        this.specialitySaveGetway = specialitySaveGetway;
    }

    public Speciality saveSpeciality(Speciality speciality){
            return specialitySaveGetway.save(speciality);
    }

}
