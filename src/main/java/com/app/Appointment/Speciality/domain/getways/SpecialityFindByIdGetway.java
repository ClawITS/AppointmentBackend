package com.app.Appointment.Speciality.domain.getways;

import com.app.Appointment.Speciality.domain.model.Speciality;

public interface SpecialityFindByIdGetway {
    Speciality findById(Long id);
}
