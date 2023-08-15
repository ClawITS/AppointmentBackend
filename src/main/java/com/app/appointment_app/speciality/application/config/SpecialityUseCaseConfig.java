package com.app.appointment_app.speciality.application.config;

import com.app.appointment_app.speciality.domain.getways.SpecialityDeleteGetway;
import com.app.appointment_app.speciality.domain.getways.SpecialityFindAllGetway;
import com.app.appointment_app.speciality.domain.getways.SpecialityFindByIdGetway;
import com.app.appointment_app.speciality.domain.getways.SpecialitySaveGetway;
import com.app.appointment_app.speciality.domain.usecases.SpecialityDeleteUseCase;
import com.app.appointment_app.speciality.domain.usecases.SpecialityFindAllUseCase;
import com.app.appointment_app.speciality.domain.usecases.SpecialityFindByIdUseCase;
import com.app.appointment_app.speciality.domain.usecases.SpecialitySaveUseCase;
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
