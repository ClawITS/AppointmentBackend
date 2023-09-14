package com.app.appointment_app.disponibility.domain.usecases.cruds;

import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilityDeleteByIdGetway;

public class DisponibilityDeleteUseCase {
    private final DisponibilityDeleteByIdGetway disponibilityDeleteByIdGetway;

    public DisponibilityDeleteUseCase(DisponibilityDeleteByIdGetway disponibilityDeleteByIdGetway) {
        this.disponibilityDeleteByIdGetway = disponibilityDeleteByIdGetway;
    }

    public void deleteDisponibilityById(Long id){
         disponibilityDeleteByIdGetway.deleteById(id);
    }
}
