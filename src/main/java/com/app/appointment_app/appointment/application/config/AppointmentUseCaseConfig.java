package com.app.appointment_app.appointment.application.config;

import com.app.appointment_app.appointment.domain.usecases.AppointmentFindByIdUseCase;
import com.app.appointment_app.appointment.domain.usecases.AppointmentDeleteUseCase;
import com.app.appointment_app.appointment.domain.usecases.AppointmentFindAllUseCase;
import com.app.appointment_app.appointment.domain.usecases.AppointmentSaveUseCase;
import com.app.appointment_app.appointment.domain.getways.AppointmentDeleteGetway;
import com.app.appointment_app.appointment.domain.getways.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.getways.AppointmentSaveGetway;
import com.app.appointment_app.appointment.domain.getways.AppointmentFindAllGetway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppointmentUseCaseConfig {
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
