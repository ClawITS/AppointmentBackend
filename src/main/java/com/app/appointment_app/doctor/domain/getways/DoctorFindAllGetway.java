package com.app.appointment_app.doctor.domain.getways;

import com.app.appointment_app.doctor.domain.model.Doctor;
import org.springframework.data.domain.Page;

public interface DoctorFindAllGetway {
    Page<Doctor> findAllPaginator(int numberPage);
}
