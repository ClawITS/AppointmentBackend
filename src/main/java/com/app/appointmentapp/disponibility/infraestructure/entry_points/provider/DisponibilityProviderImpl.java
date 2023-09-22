package com.app.appointmentapp.disponibility.infraestructure.entry_points.provider;

import com.app.appointmentapp.disponibility.domain.usecases.cruds.DisponibilityDeleteUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.cruds.DisponibilityFindAllUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.cruds.DisponibilityFindByIdUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.cruds.DisponibilitySaveUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.filters.DisponibilityFilterByDoctorAndHourUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.filters.DisponibilityFilterByHourUseCase;
import com.app.appointmentapp.disponibility.infraestructure.dto.mappers.DisponibilityGetByIdMapper;
import org.springframework.stereotype.Component;

@Component
public class DisponibilityProviderImpl implements DisponibilityProvider{
    private final DisponibilitySaveUseCase disponibilitySaveUseCase;
    private final DisponibilityDeleteUseCase disponibilityDeleteUseCase;
    private final DisponibilityFindAllUseCase disponibilityFindAllUseCase;
    private final DisponibilityFindByIdUseCase disponibilityFindByIdUseCase;
    private final DisponibilityFilterByHourUseCase disponibilityFilterByHourUseCase;
    private final DisponibilityFilterByDoctorAndHourUseCase disponibilityFilterByDoctorAndHourUseCase;
    private final DisponibilityGetByIdMapper disponibilityGetByIdMapper;

    public DisponibilityProviderImpl(DisponibilitySaveUseCase disponibilitySaveUseCase, DisponibilityDeleteUseCase disponibilityDeleteUseCase, DisponibilityFindAllUseCase disponibilityFindAllUseCase, DisponibilityFindByIdUseCase disponibilityFindByIdUseCase, DisponibilityFilterByHourUseCase disponibilityFilterByHourUseCase, DisponibilityFilterByDoctorAndHourUseCase disponibilityFilterByDoctorAndHourUseCase, DisponibilityGetByIdMapper disponibilityGetByIdMapper) {
        this.disponibilitySaveUseCase = disponibilitySaveUseCase;
        this.disponibilityDeleteUseCase = disponibilityDeleteUseCase;
        this.disponibilityFindAllUseCase = disponibilityFindAllUseCase;
        this.disponibilityFindByIdUseCase = disponibilityFindByIdUseCase;
        this.disponibilityFilterByHourUseCase = disponibilityFilterByHourUseCase;
        this.disponibilityFilterByDoctorAndHourUseCase = disponibilityFilterByDoctorAndHourUseCase;
        this.disponibilityGetByIdMapper = disponibilityGetByIdMapper;
    }

    @Override
    public DisponibilitySaveUseCase getDisponibilitySaveUseCase() {
        return disponibilitySaveUseCase;
    }

    @Override
    public DisponibilityDeleteUseCase getDisponibilityDeleteUseCase() {
        return disponibilityDeleteUseCase;
    }

    @Override
    public DisponibilityFindAllUseCase getDisponibilityFindAllUseCase() {
        return disponibilityFindAllUseCase;
    }

    @Override
    public DisponibilityFindByIdUseCase getDisponibilityFindByIdUseCase() {
        return disponibilityFindByIdUseCase;
    }

    @Override
    public DisponibilityFilterByHourUseCase getDisponibilityFilterByHourUseCase() {
        return disponibilityFilterByHourUseCase;
    }

    @Override
    public DisponibilityFilterByDoctorAndHourUseCase getDisponibilityFilterByDoctorAndHourUseCase() {
        return disponibilityFilterByDoctorAndHourUseCase;
    }

    @Override
    public DisponibilityGetByIdMapper dispibilityGetByIdMapper() {
        return disponibilityGetByIdMapper;
    }
}
