package com.app.appointment_app.doctor.domain.getways;

import com.app.appointment_app.doctor.domain.model.Doctor;

public interface DoctorFindByIdGetway {
    Doctor findById(Long id);
}