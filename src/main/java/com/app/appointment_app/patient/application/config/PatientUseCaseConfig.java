package com.app.appointment_app.patient.application.config;

import com.app.appointment_app.patient.domain.getways.*;
import com.app.appointment_app.patient.domain.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientUseCaseConfig {
    @Bean
    public CancelReschedulingUseCase cancelReschedulingUseCase(CancelReschedulingGetway cancelReschedulingGetway){
        return new CancelReschedulingUseCase(cancelReschedulingGetway);
    }
    @Bean
    public AcceptReschedulingUseCase acceptReschedulingUseCaseConfig(AcceptReschedulingGetway acceptReschedulingGetway){
        return new AcceptReschedulingUseCase(acceptReschedulingGetway);
    }
    @Bean
    public PatientSaveUseCase patientSaveUseCaseConfig(PatientSaveGetway patientSaveGetway){
        return new PatientSaveUseCase(patientSaveGetway);
    }
    
    @Bean
    public PatientDeleteUseCase patientDeleteUseCaseConfig(PatientDeleteGetway patientDeleteGetway){
        return new PatientDeleteUseCase(patientDeleteGetway);
    }
    
    @Bean
    public PatientFindByIdUseCase patientFindByIdUseCaseConfig(PatientFindByIdGetway patientFindByIdGetway){
        return new PatientFindByIdUseCase(patientFindByIdGetway);
    }
    
    @Bean
    public PatientFindAllUseCase patientFindAllUseCaseConfig(PatientFindAllGetway patientFindAllGetway){
        return new PatientFindAllUseCase(patientFindAllGetway);
    }
}
