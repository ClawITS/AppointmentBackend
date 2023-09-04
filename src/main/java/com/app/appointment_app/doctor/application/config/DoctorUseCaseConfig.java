package com.app.appointment_app.doctor.application.config;

import com.app.appointment_app.doctor.domain.getways.*;

import com.app.appointment_app.doctor.domain.useCases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoctorUseCaseConfig {

    @Bean
    public RescheduleAppointmentUseCase rescheduleAppointmentUseCaseConfig(RescheduleAppointmentGetway rescheduleAppointmentGetyaw){
        return new RescheduleAppointmentUseCase(rescheduleAppointmentGetyaw);
    }

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
