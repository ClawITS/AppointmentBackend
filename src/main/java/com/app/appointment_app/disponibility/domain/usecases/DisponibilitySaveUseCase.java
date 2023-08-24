package com.app.appointment_app.disponibility.domain.usecases;

import com.app.appointment_app.disponibility.domain.getways.DisponibilitySaveGetway;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.model.enums.DisponibilityState;

public class DisponibilitySaveUseCase {
    private final DisponibilitySaveGetway disponibilitySaveGetway;

    public DisponibilitySaveUseCase(DisponibilitySaveGetway disponibilitySaveGetway) {
        this.disponibilitySaveGetway = disponibilitySaveGetway;
    }

    public Disponibility saveDisponibility(Disponibility disponibility){
        disponibility.setDisponibilityState(DisponibilityState.AVAILABLE);
        return disponibilitySaveGetway.save(disponibility);
    }
}
