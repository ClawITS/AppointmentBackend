package com.app.appointment_app.speciality.infraestructure.entry_point.provider;

import com.app.appointment_app.speciality.domain.usecases.cruds.SpecialityDeleteUseCase;
import com.app.appointment_app.speciality.domain.usecases.cruds.SpecialityFindAllUseCase;
import com.app.appointment_app.speciality.domain.usecases.cruds.SpecialityFindByIdUseCase;
import com.app.appointment_app.speciality.domain.usecases.cruds.SpecialitySaveUseCase;

public interface SpecialityProvider {
    SpecialityFindByIdUseCase getSpecialityFindByIdUseCase();
    SpecialitySaveUseCase getSpecialitySaveUseCase();
    SpecialityFindAllUseCase getSpecialityFindAllUseCase();
    SpecialityDeleteUseCase getSpecialityDeleteUseCase();
}
