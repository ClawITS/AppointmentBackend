package com.app.appointmentapp.doctor.domain.getways.cruds;

import com.app.appointmentapp.doctor.domain.model.Doctor;

public interface DoctorFindByIdGetway {
    Doctor findById(Long id);
}
