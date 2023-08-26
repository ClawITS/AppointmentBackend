package com.app.appointment_app.appointment.application.config;

import com.app.appointment_app.appointment.domain.getways.*;
import com.app.appointment_app.appointment.domain.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppointmentUseCaseConfig {
    @Bean
    public CloseAppointmentUseCase closeAppointmentUseCaseConfig(CloseAppointmentGetway closeAppointmentGetway){
        return new CloseAppointmentUseCase(closeAppointmentGetway);
    }
    @Bean
    public AppointmentSaveUseCase appointmentSaveUseCaseConfig(AppointmentSaveGetway appointmentSaveGetway) {
        return new AppointmentSaveUseCase(appointmentSaveGetway);
    }

    @Bean
    public AppointmentDeleteUseCase appointmentDeleteUseCaseConfig(AppointmentDeleteGetway appointmentDeleteGetway) {
        return new AppointmentDeleteUseCase(appointmentDeleteGetway);
    }

    @Bean
    public AppointmentFindByIdUseCase appointmentFindByIdUseCaseConfig(AppointmentFindByIdGetway appointmentFindByIdGetway) {
        return new AppointmentFindByIdUseCase(appointmentFindByIdGetway);
    }

    @Bean
    public AppointmentFindAllUseCase appointmentFindAllUseCaseConfig(AppointmentFindAllGetway appointmentFindAllGetway) {
        return new AppointmentFindAllUseCase(appointmentFindAllGetway);
    }
}
