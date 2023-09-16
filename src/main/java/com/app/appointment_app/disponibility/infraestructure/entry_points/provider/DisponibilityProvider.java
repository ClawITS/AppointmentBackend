package com.app.appointment_app.disponibility.infraestructure.entry_points.provider;

import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilityDeleteUseCase;
import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilityFindAllUseCase;
import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilityFindByIdUseCase;
import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilitySaveUseCase;
import com.app.appointment_app.disponibility.domain.usecases.filters.DisponibilityFilterByDoctorAndHourUseCase;
import com.app.appointment_app.disponibility.domain.usecases.filters.DisponibilityFilterByHourUseCase;

public interface DisponibilityProvider {
    DisponibilitySaveUseCase getDisponibilitySaveUseCase();
    DisponibilityDeleteUseCase getDisponibilityDeleteUseCase();
    DisponibilityFindAllUseCase getDisponibilityFindAllUseCase();
    DisponibilityFindByIdUseCase getDisponibilityFindByIdUseCase();
    DisponibilityFilterByHourUseCase getDisponibilityFilterByHourUseCase();
    DisponibilityFilterByDoctorAndHourUseCase getDisponibilityFilterByDoctorAndHourUseCase();
}
