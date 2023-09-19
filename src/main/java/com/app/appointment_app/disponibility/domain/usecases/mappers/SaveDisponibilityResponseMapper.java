package com.app.appointment_app.disponibility.domain.usecases.mappers;


import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.responses.DisponibilitySaveResponse;

public class SaveDisponibilityResponseMapper {
    public DisponibilitySaveResponse toSaveResponse(Disponibility disponibility){
        return new DisponibilitySaveResponse.Builder()
                .hour(disponibility.getHour())
                .doctor(disponibility.getDoctor().getName())
                .build();

    }
}
