package com.app.appointment_app.disponibility.application.config;

import com.app.appointment_app.disponibility.domain.getways.DisponibilityDeleteByIdGetway;
import com.app.appointment_app.disponibility.domain.getways.DisponibilityFindAllGetway;
import com.app.appointment_app.disponibility.domain.getways.DisponibilityFindByIdGetway;
import com.app.appointment_app.disponibility.domain.getways.DisponibilitySaveGetway;
import com.app.appointment_app.disponibility.domain.usecases.DisponibilityDeleteUseCase;
import com.app.appointment_app.disponibility.domain.usecases.DisponibilityFindAllUseCase;
import com.app.appointment_app.disponibility.domain.usecases.DisponibilityFindByIdUseCase;
import com.app.appointment_app.disponibility.domain.usecases.DisponibilitySaveUseCase;
import com.app.appointment_app.disponibility.domain.usecases.helpers.DisponibilitySaveHelper;
import com.app.appointment_app.doctor.domain.getways.DoctorFindByIdGetway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DisponibilityUseCaseConfig {
    @Bean
    public DisponibilitySaveHelper disponibilitySaveHelperConfig(DoctorFindByIdGetway doctorFindByIdGetway){
        return new DisponibilitySaveHelper(doctorFindByIdGetway);
    }
    @Bean
    public DisponibilitySaveUseCase disponibilitySaveUseCaseConfig(DisponibilitySaveGetway disponibilitySaveGetway
            , DisponibilitySaveHelper disponibilitySaveHelper){
        return new DisponibilitySaveUseCase(disponibilitySaveGetway, disponibilitySaveHelper);

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
