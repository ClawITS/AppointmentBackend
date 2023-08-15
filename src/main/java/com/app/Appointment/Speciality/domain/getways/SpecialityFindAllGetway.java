package com.app.Appointment.Speciality.domain.getways;

import com.app.Appointment.Speciality.domain.model.Speciality;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SpecialityFindAllGetway {
    Page<Speciality> findAllPaginator(int numberPage);
    List<Speciality> findAll();
}
