package com.app.appointment_app.speciality.infraestructure.entry_point.provider;

import com.app.appointment_app.speciality.domain.usecases.cruds.SpecialityDeleteUseCase;
import com.app.appointment_app.speciality.domain.usecases.cruds.SpecialityFindAllUseCase;
import com.app.appointment_app.speciality.domain.usecases.cruds.SpecialityFindByIdUseCase;
import com.app.appointment_app.speciality.domain.usecases.cruds.SpecialitySaveUseCase;
import org.springframework.stereotype.Component;

@Component
public class SpecialityProviderImpl implements SpecialityProvider{
    private final SpecialityFindByIdUseCase specialityFindByIdUseCase;
    private final SpecialitySaveUseCase specialitySaveUseCase;
    private final SpecialityFindAllUseCase specialityFindAllUseCase;
    private final SpecialityDeleteUseCase specialityDeleteUseCase;

    public SpecialityProviderImpl(SpecialityFindByIdUseCase specialityFindByIdUseCase, SpecialitySaveUseCase specialitySaveUseCase, SpecialityFindAllUseCase specialityFindAllUseCase, SpecialityDeleteUseCase specialityDeleteUseCase) {
        this.specialityFindByIdUseCase = specialityFindByIdUseCase;
        this.specialitySaveUseCase = specialitySaveUseCase;
        this.specialityFindAllUseCase = specialityFindAllUseCase;
        this.specialityDeleteUseCase = specialityDeleteUseCase;
    }

    @Override
    public SpecialityFindByIdUseCase getSpecialityFindByIdUseCase() {
        return specialityFindByIdUseCase;
    }

    @Override
    public SpecialitySaveUseCase getSpecialitySaveUseCase() {
        return specialitySaveUseCase;
    }

    @Override
    public SpecialityFindAllUseCase getSpecialityFindAllUseCase() {
        return specialityFindAllUseCase;
    }

    @Override
    public SpecialityDeleteUseCase getSpecialityDeleteUseCase() {
        return specialityDeleteUseCase;
    }
}
