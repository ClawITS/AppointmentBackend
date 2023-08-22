package com.app.appointment_app.doctor.application.config;

import com.app.appointment_app.doctor.domain.getways.*;

import com.app.appointment_app.doctor.domain.useCases.DoctorDeleteUseCase;
import com.app.appointment_app.doctor.domain.useCases.DoctorFindAllUseCase;
import com.app.appointment_app.doctor.domain.useCases.DoctorFindByIdUseCase;
import com.app.appointment_app.doctor.domain.useCases.DoctorSaveUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoctorUseCaseConfig {

    @Bean
    public DoctorSaveUseCase doctorSaveUseCaseConfig(DoctorSaveGetway doctorSaveGetway, DoctorDisponibilityRelationGetway
                                                     doctorDisponibilityRelationGetway){
        return new DoctorSaveUseCase(doctorSaveGetway, doctorDisponibilityRelationGetway);
    }
    @Bean
    public DoctorDeleteUseCase doctorDeleteUseCaseConfig(DoctorDeleteGetway doctorDeleteGetway){
        return new DoctorDeleteUseCase(doctorDeleteGetway);
    }
    @Bean
    public DoctorFindByIdUseCase doctorFindByIdUseCase(DoctorFindByIdGetway doctorFindByIdGetway){
        return new DoctorFindByIdUseCase(doctorFindByIdGetway);
    }
    @Bean
    public DoctorFindAllUseCase doctorFindAllUseCaseConfig(DoctorFindAllGetway doctorFindAllGetway){
        return new DoctorFindAllUseCase(doctorFindAllGetway);
    }
}
