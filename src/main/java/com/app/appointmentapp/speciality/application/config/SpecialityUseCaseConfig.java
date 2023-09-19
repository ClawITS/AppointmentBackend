package com.app.appointmentapp.speciality.application.config;

import com.app.appointmentapp.speciality.domain.getways.cruds.SpecialityDeleteGetway;
import com.app.appointmentapp.speciality.domain.getways.cruds.SpecialityFindAllGetway;
import com.app.appointmentapp.speciality.domain.getways.cruds.SpecialityFindByIdGetway;
import com.app.appointmentapp.speciality.domain.getways.cruds.SpecialitySaveGetway;
import com.app.appointmentapp.speciality.domain.usecases.cruds.SpecialityDeleteUseCase;
import com.app.appointmentapp.speciality.domain.usecases.cruds.SpecialityFindAllUseCase;
import com.app.appointmentapp.speciality.domain.usecases.cruds.SpecialityFindByIdUseCase;
import com.app.appointmentapp.speciality.domain.usecases.cruds.SpecialitySaveUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpecialityUseCaseConfig {
    @Bean
    public SpecialitySaveUseCase specialitySaveUseCaseConfig(SpecialitySaveGetway specialitySaveGetway){
        return new SpecialitySaveUseCase(specialitySaveGetway);
    }
    @Bean
    public SpecialityDeleteUseCase specialityDeleteUseCaseConfig(SpecialityDeleteGetway specialityDeleteGetway){
        return new SpecialityDeleteUseCase(specialityDeleteGetway);
    }
    @Bean
    public SpecialityFindByIdUseCase specialityFindByIdUseCaseConfig(SpecialityFindByIdGetway specialityFindByIdGetway){
        return new SpecialityFindByIdUseCase(specialityFindByIdGetway);
    }
    @Bean
    public SpecialityFindAllUseCase specialityFindAllUseCaseConfig(SpecialityFindAllGetway specialityFindAllGetway){
        return new SpecialityFindAllUseCase(specialityFindAllGetway);
    }
}
