package com.app.appointment_app.disponibility.domain.usecases;

import com.app.appointment_app.disponibility.domain.getways.DisponibilityFindAllGetway;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import org.springframework.data.domain.Page;

public class DisponibilityFindAllUseCase {
    private final DisponibilityFindAllGetway disponibilityFindAllGetway;

    public DisponibilityFindAllUseCase(DisponibilityFindAllGetway disponibilityFindAllGetway) {
        this.disponibilityFindAllGetway = disponibilityFindAllGetway;
    }

    public Page<Disponibility> findAllDisponibilityPaginator(int numberPage){
        return disponibilityFindAllGetway.findAllDisponibilitiesPage(numberPage);
    }
}
