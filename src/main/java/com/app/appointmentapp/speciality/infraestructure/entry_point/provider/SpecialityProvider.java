package com.app.appointmentapp.speciality.infraestructure.entry_point.provider;

import com.app.appointmentapp.speciality.domain.usecases.cruds.SpecialityDeleteUseCase;
import com.app.appointmentapp.speciality.domain.usecases.cruds.SpecialityFindAllUseCase;
import com.app.appointmentapp.speciality.domain.usecases.cruds.SpecialityFindByIdUseCase;
import com.app.appointmentapp.speciality.domain.usecases.cruds.SpecialitySaveUseCase;

public interface SpecialityProvider {
    SpecialityFindByIdUseCase getSpecialityFindByIdUseCase();
    SpecialitySaveUseCase getSpecialitySaveUseCase();
    SpecialityFindAllUseCase getSpecialityFindAllUseCase();
    SpecialityDeleteUseCase getSpecialityDeleteUseCase();
}
