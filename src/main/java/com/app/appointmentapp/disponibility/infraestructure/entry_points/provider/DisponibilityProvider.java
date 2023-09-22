package com.app.appointmentapp.disponibility.infraestructure.entry_points.provider;

import com.app.appointmentapp.disponibility.domain.usecases.cruds.DisponibilityDeleteUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.cruds.DisponibilityFindAllUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.cruds.DisponibilityFindByIdUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.cruds.DisponibilitySaveUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.filters.DisponibilityFilterByDoctorAndHourUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.filters.DisponibilityFilterByHourUseCase;
import com.app.appointmentapp.disponibility.infraestructure.dto.mappers.DisponibilityGetByIdMapper;

public interface DisponibilityProvider {
    DisponibilitySaveUseCase getDisponibilitySaveUseCase();
    DisponibilityDeleteUseCase getDisponibilityDeleteUseCase();
    DisponibilityFindAllUseCase getDisponibilityFindAllUseCase();
    DisponibilityFindByIdUseCase getDisponibilityFindByIdUseCase();
    DisponibilityFilterByHourUseCase getDisponibilityFilterByHourUseCase();
    DisponibilityFilterByDoctorAndHourUseCase getDisponibilityFilterByDoctorAndHourUseCase();
    DisponibilityGetByIdMapper dispibilityGetByIdMapper();

}
