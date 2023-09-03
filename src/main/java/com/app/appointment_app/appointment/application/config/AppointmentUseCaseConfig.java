package com.app.appointment_app.appointment.application.config;

import com.app.appointment_app.appointment.domain.getways.*;
import com.app.appointment_app.appointment.domain.usecases.*;
import com.app.appointment_app.appointment.domain.usecases.helpers.AppointmentSaveHelper;
import com.app.appointment_app.appointment.domain.usecases.helpers.CloseAppointmentHelper;
import com.app.appointment_app.disponibility.domain.getways.DisponibilityFindByIdGetway;
import com.app.appointment_app.disponibility.domain.getways.DisponibilitySaveGetway;
import com.app.appointment_app.patient.domain.getways.PatientFindByIdGetway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppointmentUseCaseConfig {

    @Bean
    public CloseAppointmentHelper closeAppointmentHelperConfig(
            AppointmentFindByIdGetway appointmentFindByIdGetway
            , AppointmentSaveGetway appointmentSaveGetway, DisponibilitySaveGetway disponibilitySaveGetway){
        return new CloseAppointmentHelper(appointmentFindByIdGetway, appointmentSaveGetway, disponibilitySaveGetway);
    }

    @Bean
    public CloseAppointmentUseCase closeAppointmentUseCaseConfig(
            CloseAppointmentGetway closeAppointmentGetway, CloseAppointmentHelper closeAppointmentHelper){
        return new CloseAppointmentUseCase(closeAppointmentGetway, closeAppointmentHelper);
    }
    @Bean
    public AppointmentSaveHelper appointmentSaveHelperConfig(
            DisponibilityFindByIdGetway disponibilityFindByIdGetway, DisponibilitySaveGetway disponibilitySaveGetway,
            PatientFindByIdGetway patientFindByIdGetway){
        return new AppointmentSaveHelper(disponibilityFindByIdGetway, disponibilitySaveGetway,patientFindByIdGetway);
    }
    @Bean
    public AppointmentSaveUseCase appointmentSaveUseCaseConfig(
            AppointmentSaveGetway appointmentSaveGetway, AppointmentSaveHelper appointmentSaveHelper) {
        return new AppointmentSaveUseCase(appointmentSaveGetway, appointmentSaveHelper);
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
