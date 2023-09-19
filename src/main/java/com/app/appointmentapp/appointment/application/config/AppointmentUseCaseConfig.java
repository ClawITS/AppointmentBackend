package com.app.appointmentapp.appointment.application.config;

import com.app.appointmentapp.appointment.domain.getways.business_services.CloseAppointmentGetway;
import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentDeleteGetway;
import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentFindAllGetway;
import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentSaveGetway;
import com.app.appointmentapp.appointment.domain.usecases.business_services.CloseAppointmentUseCase;
import com.app.appointmentapp.appointment.domain.usecases.cruds.AppointmentDeleteUseCase;
import com.app.appointmentapp.appointment.domain.usecases.cruds.AppointmentFindAllUseCase;
import com.app.appointmentapp.appointment.domain.usecases.cruds.AppointmentFindByIdUseCase;
import com.app.appointmentapp.appointment.domain.usecases.cruds.AppointmentSaveUseCase;
import com.app.appointmentapp.appointment.domain.usecases.helpers.AppointmentSaveHelper;
import com.app.appointmentapp.appointment.domain.usecases.helpers.CloseAppointmentHelper;
import com.app.appointmentapp.disponibility.domain.getways.cruds.DisponibilityFindByIdGetway;
import com.app.appointmentapp.disponibility.domain.getways.cruds.DisponibilitySaveGetway;
import com.app.appointmentapp.patient.domain.getways.cruds.PatientFindByIdGetway;
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
