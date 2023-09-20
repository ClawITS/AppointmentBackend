package com.app.appointmentapp.disponibility.domain.usecases.cruds;
import com.app.appointmentapp.disponibility.domain.getways.cruds.DisponibilityFindByIdGetway;
import com.app.appointmentapp.disponibility.domain.model.Disponibility;

public class DisponibilityFindByIdUseCase {
    private final DisponibilityFindByIdGetway disponibilityFindByIdGetway;

    public DisponibilityFindByIdUseCase(DisponibilityFindByIdGetway disponibilityFindByIdGetway) {
        this.disponibilityFindByIdGetway = disponibilityFindByIdGetway;
    }
    public Disponibility findDisponibilityById(Long id){
        return disponibilityFindByIdGetway.findById(id);
    }
}
