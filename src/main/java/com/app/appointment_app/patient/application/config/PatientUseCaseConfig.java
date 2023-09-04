package com.app.appointment_app.patient.application.config;

import com.app.appointment_app.appointment.domain.getways.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.getways.AppointmentSaveGetway;
import com.app.appointment_app.patient.domain.getways.*;
import com.app.appointment_app.patient.domain.usecases.*;
import com.app.appointment_app.patient.domain.usecases.helpers.AcceptReschedulingHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientUseCaseConfig {
    @Bean
    public PatientResheduleUseCase patientResheduleUseCaseConfig(PatientRescheduleGetway patientRescheduleGetway){
        return new PatientResheduleUseCase(patientRescheduleGetway);
    }
    @Bean
    public CancelReschedulingUseCase cancelReschedulingUseCaseConfig(CancelReschedulingGetway cancelReschedulingGetway){
        return new CancelReschedulingUseCase(cancelReschedulingGetway);
    }
    @Bean
    public AcceptReschedulingHelper acceptReschedulingHelperConfig(AppointmentSaveGetway appointmentSaveGetway
            , AppointmentFindByIdGetway appointmentFindByIdGetway){
        return new AcceptReschedulingHelper(appointmentSaveGetway, appointmentFindByIdGetway);
    }
    @Bean
    public AcceptReschedulingUseCase acceptReschedulingUseCaseConfig(AcceptReschedulingGetway acceptReschedulingGetway
            , AcceptReschedulingHelper acceptReschedulingHelper){
        return new AcceptReschedulingUseCase(acceptReschedulingGetway, acceptReschedulingHelper);
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
