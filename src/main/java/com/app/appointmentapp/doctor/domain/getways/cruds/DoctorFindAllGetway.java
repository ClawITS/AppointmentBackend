package com.app.appointmentapp.doctor.domain.getways.cruds;

import com.app.appointmentapp.doctor.domain.model.Doctor;
import org.springframework.data.domain.Page;

public interface DoctorFindAllGetway {
    Page<Doctor> findAllPaginator(int numberPage);
}
