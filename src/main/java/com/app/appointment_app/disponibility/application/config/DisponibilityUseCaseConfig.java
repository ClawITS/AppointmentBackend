package com.app.appointment_app.disponibility.application.config;

import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilityDeleteByIdGetway;
import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilityFindAllGetway;
import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilityFindByIdGetway;
import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilitySaveGetway;
import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilityDeleteUseCase;
import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilityFindAllUseCase;
import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilityFindByIdUseCase;
import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilitySaveUseCase;
import com.app.appointment_app.disponibility.domain.usecases.helpers.DisponibilitySaveHelper;
import com.app.appointment_app.doctor.domain.getways.cruds.DoctorFindByIdGetway;
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
