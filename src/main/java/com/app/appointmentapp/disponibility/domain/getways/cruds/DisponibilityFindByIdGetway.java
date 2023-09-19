package com.app.appointmentapp.disponibility.domain.getways.cruds;

import com.app.appointmentapp.disponibility.domain.model.Disponibility;

public interface DisponibilityFindByIdGetway {
    Disponibility findById(Long id);
}
