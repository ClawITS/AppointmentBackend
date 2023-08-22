package com.app.appointment_app.disponibility.domain.getways;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import org.springframework.data.domain.Page;

public interface DisponibilityFindAllGetway {
    Page<Disponibility> findAllDisponibilitiesPage(int numberPage);
}
