package com.app.appointmentapp.disponibility.domain.getways.cruds;

import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import org.springframework.data.domain.Page;

public interface DisponibilityFindAllGetway {
    Page<Disponibility> findAllDisponibilitiesPage(int numberPage);
}
