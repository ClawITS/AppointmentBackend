package com.app.appointment_app.disponibility.domain.getways;

import com.app.appointment_app.disponibility.domain.model.Disponibility;

public interface DisponibilityFindByIdGetway {
    Disponibility findById(Long id);
}
