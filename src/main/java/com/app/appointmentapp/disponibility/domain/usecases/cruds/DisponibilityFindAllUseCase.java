package com.app.appointmentapp.disponibility.domain.usecases.cruds;

import com.app.appointmentapp.disponibility.domain.getways.cruds.DisponibilityFindAllGetway;
import com.app.appointmentapp.disponibility.domain.model.Disponibility;
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
