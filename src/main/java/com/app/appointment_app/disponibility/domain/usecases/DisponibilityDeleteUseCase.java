package com.app.appointment_app.disponibility.domain.usecases;

import com.app.appointment_app.disponibility.domain.getways.DisponibilityDeleteByIdGetway;
import com.app.appointment_app.disponibility.domain.model.Disponibility;

public class DisponibilityDeleteUseCase {
    private final DisponibilityDeleteByIdGetway disponibilityDeleteByIdGetway;

    public DisponibilityDeleteUseCase(DisponibilityDeleteByIdGetway disponibilityDeleteByIdGetway) {
        this.disponibilityDeleteByIdGetway = disponibilityDeleteByIdGetway;
    }

    public void deleteDisponibilityById(Long id){
         disponibilityDeleteByIdGetway.deleteById(id);
    }
}
