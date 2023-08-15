package com.app.appointment_app.speciality.domain.getways;

import com.app.appointment_app.speciality.domain.model.Speciality;

public interface SpecialityFindByIdGetway {
    Speciality findById(Long id);
}
