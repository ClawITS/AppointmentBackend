package com.app.appointment_app.disponibility.application.config;

import com.app.appointment_app.disponibility.domain.getways.DisponibilityDeleteByIdGetway;
import com.app.appointment_app.disponibility.domain.getways.DisponibilityFindAllGetway;
import com.app.appointment_app.disponibility.domain.getways.DisponibilityFindByIdGetway;
import com.app.appointment_app.disponibility.domain.getways.DisponibilitySaveGetway;
import com.app.appointment_app.disponibility.domain.usecases.DisponibilityDeleteUseCase;
import com.app.appointment_app.disponibility.domain.usecases.DisponibilityFindAllUseCase;
import com.app.appointment_app.disponibility.domain.usecases.DisponibilityFindByIdUseCase;
import com.app.appointment_app.disponibility.domain.usecases.DisponibilitySaveUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DisponibilityUseCaseConfig {
    @Bean
    public DisponibilitySaveUseCase disponibilitySaveUseCaseConfig(DisponibilitySaveGetway disponibilitySaveGetway){
        return new DisponibilitySaveUseCase(disponibilitySaveGetway);

    }
    @Bean
    public DisponibilityDeleteUseCase disponibilityDeleteUseCaseConfig(
            DisponibilityDeleteByIdGetway disponibilityDeleteByIdGetway){
        return new DisponibilityDeleteUseCase(disponibilityDeleteByIdGetway);

    }
    @Bean
    public DisponibilityFindByIdUseCase disponibilityFindByIdUseCaseConfig(DisponibilityFindByIdGetway
                                                                           disponibilityFindByIdGetway){
        return new DisponibilityFindByIdUseCase(disponibilityFindByIdGetway);

    }
    @Bean
    public DisponibilityFindAllUseCase disponibilityFindAllUseCase(DisponibilityFindAllGetway
                                                                   disponibilityFindAllGetway){
        return new DisponibilityFindAllUseCase(disponibilityFindAllGetway);

    }

}
