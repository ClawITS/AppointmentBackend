package com.app.appointmentapp.speciality.domain.getways.cruds;

import com.app.appointmentapp.speciality.domain.model.Speciality;

public interface SpecialityFindByIdGetway {
    Speciality findById(Long id);
}
