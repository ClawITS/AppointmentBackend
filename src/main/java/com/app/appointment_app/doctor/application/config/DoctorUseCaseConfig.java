package com.app.appointment_app.doctor.application.config;

import com.app.appointment_app.doctor.domain.getways.DoctorDeleteGetway;
import com.app.appointment_app.doctor.domain.getways.DoctorFindAllGetway;
import com.app.appointment_app.doctor.domain.getways.DoctorFindByIdGetway;
import com.app.appointment_app.doctor.domain.getways.DoctorSaveGetway;
import com.app.appointment_app.doctor.domain.usecases.DoctorDeleteUseCase;
import com.app.appointment_app.doctor.domain.usecases.DoctorFindAllUseCase;
import com.app.appointment_app.doctor.domain.usecases.DoctorFindByIdUseCase;
import com.app.appointment_app.doctor.domain.usecases.DoctorSaveUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoctorUseCaseConfig {

    @Bean
    public DoctorSaveUseCase doctorSaveUseCaseConfig(DoctorSaveGetway doctorSaveGetway){
        return new DoctorSaveUseCase(doctorSaveGetway);
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
