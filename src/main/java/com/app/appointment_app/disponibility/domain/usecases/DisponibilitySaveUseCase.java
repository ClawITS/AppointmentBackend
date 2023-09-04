package com.app.appointment_app.disponibility.domain.usecases;

import com.app.appointment_app.disponibility.domain.getways.DisponibilitySaveGetway;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.model.enums.DisponibilityState;
import com.app.appointment_app.disponibility.domain.requests.DisponibilitySaveRequest;
import com.app.appointment_app.disponibility.domain.usecases.helpers.DisponibilitySaveHelper;

public class DisponibilitySaveUseCase {
    private final DisponibilitySaveGetway disponibilitySaveGetway;
    private final DisponibilitySaveHelper disponibilitySaveHelper;

    public DisponibilitySaveUseCase(DisponibilitySaveGetway disponibilitySaveGetway, DisponibilitySaveHelper disponibilitySaveHelper) {
        this.disponibilitySaveGetway = disponibilitySaveGetway;
        this.disponibilitySaveHelper = disponibilitySaveHelper;
    }

    public Disponibility saveDisponibility(DisponibilitySaveRequest disponibilitySaveRequest){
        Disponibility disponibility = disponibilitySaveHelper.addDoctorToDisponibility(disponibilitySaveRequest);
        disponibility.setDisponibilityState(DisponibilityState.AVAILABLE);
        return disponibilitySaveGetway.save(disponibility);
    }
}
