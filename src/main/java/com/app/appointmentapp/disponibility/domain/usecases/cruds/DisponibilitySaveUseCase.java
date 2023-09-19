package com.app.appointmentapp.disponibility.domain.usecases.cruds;

import com.app.appointmentapp.disponibility.domain.getways.cruds.DisponibilitySaveGetway;
import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.domain.model.enums.DisponibilityState;
import com.app.appointmentapp.disponibility.domain.requests.DisponibilitySaveRequest;
import com.app.appointmentapp.disponibility.domain.responses.DisponibilitySaveResponse;
import com.app.appointmentapp.disponibility.domain.usecases.helpers.DisponibilitySaveHelper;
import com.app.appointmentapp.disponibility.domain.usecases.mappers.SaveDisponibilityResponseMapper;

public class DisponibilitySaveUseCase {
    private final DisponibilitySaveGetway disponibilitySaveGetway;
    private final DisponibilitySaveHelper disponibilitySaveHelper;
    private final SaveDisponibilityResponseMapper saveDisponibilityResponseMapper;

    public DisponibilitySaveUseCase(DisponibilitySaveGetway disponibilitySaveGetway, DisponibilitySaveHelper disponibilitySaveHelper, SaveDisponibilityResponseMapper saveDisponibilityResponseMapper) {
        this.disponibilitySaveGetway = disponibilitySaveGetway;
        this.disponibilitySaveHelper = disponibilitySaveHelper;
        this.saveDisponibilityResponseMapper = saveDisponibilityResponseMapper;
    }

    public DisponibilitySaveResponse saveDisponibility(DisponibilitySaveRequest disponibilitySaveRequest){
        Disponibility disponibility = disponibilitySaveHelper.addDoctorToDisponibility(disponibilitySaveRequest);
        disponibility.setDisponibilityState(DisponibilityState.AVAILABLE);
        return saveDisponibilityResponseMapper
                .toSaveResponse(disponibilitySaveGetway.save(disponibility));
    }
}
