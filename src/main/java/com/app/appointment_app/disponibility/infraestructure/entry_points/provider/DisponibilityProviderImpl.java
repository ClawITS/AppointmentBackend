package com.app.appointment_app.disponibility.infraestructure.entry_points.provider;

import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilityDeleteUseCase;
import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilityFindAllUseCase;
import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilityFindByIdUseCase;
import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilitySaveUseCase;
import com.app.appointment_app.disponibility.domain.usecases.filters.DisponibilityFilterByDoctorAndHourUseCase;
import com.app.appointment_app.disponibility.domain.usecases.filters.DisponibilityFilterByHourUseCase;
import org.springframework.stereotype.Component;

@Component
public class DisponibilityProviderImpl implements DisponibilityProvider{
    private final DisponibilitySaveUseCase disponibilitySaveUseCase;
    private final DisponibilityDeleteUseCase disponibilityDeleteUseCase;
    private final DisponibilityFindAllUseCase disponibilityFindAllUseCase;
    private final DisponibilityFindByIdUseCase disponibilityFindByIdUseCase;
    private final DisponibilityFilterByHourUseCase disponibilityFilterByHourUseCase;
    private final DisponibilityFilterByDoctorAndHourUseCase disponibilityFilterByDoctorAndHourUseCase;

    public DisponibilityProviderImpl(DisponibilitySaveUseCase disponibilitySaveUseCase, DisponibilityDeleteUseCase disponibilityDeleteUseCase, DisponibilityFindAllUseCase disponibilityFindAllUseCase, DisponibilityFindByIdUseCase disponibilityFindByIdUseCase, DisponibilityFilterByHourUseCase disponibilityFilterByHourUseCase, DisponibilityFilterByDoctorAndHourUseCase disponibilityFilterByDoctorAndHourUseCase) {
        this.disponibilitySaveUseCase = disponibilitySaveUseCase;
        this.disponibilityDeleteUseCase = disponibilityDeleteUseCase;
        this.disponibilityFindAllUseCase = disponibilityFindAllUseCase;
        this.disponibilityFindByIdUseCase = disponibilityFindByIdUseCase;
        this.disponibilityFilterByHourUseCase = disponibilityFilterByHourUseCase;
        this.disponibilityFilterByDoctorAndHourUseCase = disponibilityFilterByDoctorAndHourUseCase;
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
}
