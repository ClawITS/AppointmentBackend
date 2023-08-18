package com.app.appointment_app.patient.application.config;

import com.app.appointment_app.patient.domain.getways.PatientDeleteGetway;
import com.app.appointment_app.patient.domain.getways.PatientFindAllGetway;
import com.app.appointment_app.patient.domain.getways.PatientFindByIdGetway;
import com.app.appointment_app.patient.domain.getways.PatientSaveGetway;
import com.app.appointment_app.patient.domain.usecases.PatientDeleteUseCase;
import com.app.appointment_app.patient.domain.usecases.PatientFindAllUseCase;
import com.app.appointment_app.patient.domain.usecases.PatientFindByIdUseCase;
import com.app.appointment_app.patient.domain.usecases.PatientSaveUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientUseCaseConfig {
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
