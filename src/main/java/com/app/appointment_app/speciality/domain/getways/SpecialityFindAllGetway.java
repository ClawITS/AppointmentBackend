package com.app.appointment_app.speciality.domain.getways;

import com.app.appointment_app.speciality.domain.model.Speciality;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SpecialityFindAllGetway {
    Page<Speciality> findAllPaginator(int numberPage);
    List<Speciality> findAll();
}
