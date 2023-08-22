package com.app.appointment_app.doctor.domain.getways;

import com.app.appointment_app.doctor.domain.model.Doctor;

public interface DoctorSaveGetway {
    Doctor saveDoctor(Doctor doctor);
}
