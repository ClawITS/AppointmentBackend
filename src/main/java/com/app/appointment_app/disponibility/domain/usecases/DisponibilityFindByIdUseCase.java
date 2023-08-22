package com.app.appointment_app.disponibility.domain.usecases;

import com.app.appointment_app.disponibility.domain.getways.DisponibilityFindByIdGetway;
import com.app.appointment_app.disponibility.domain.model.Disponibility;

public class DisponibilityFindByIdUseCase {
    private final DisponibilityFindByIdGetway disponibilityFindByIdGetway;

    public DisponibilityFindByIdUseCase(DisponibilityFindByIdGetway disponibilityFindByIdGetway) {
        this.disponibilityFindByIdGetway = disponibilityFindByIdGetway;
    }
    public Disponibility findDisponibilityById(Long id){
        return disponibilityFindByIdGetway.findById(id);
    }
}
