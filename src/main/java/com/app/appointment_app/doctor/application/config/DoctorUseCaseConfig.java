package com.app.appointment_app.doctor.application.config;

import com.app.appointment_app.appointment.domain.getways.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.getways.AppointmentSaveGetway;
import com.app.appointment_app.disponibility.domain.getways.DisponibilitySaveGetway;
import com.app.appointment_app.doctor.domain.getways.*;

import com.app.appointment_app.doctor.domain.useCases.*;
import com.app.appointment_app.doctor.domain.useCases.helpers.RescheduleAppointmentHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoctorUseCaseConfig {
    @Bean
    public RescheduleAppointmentHelper rescheduleAppointmentHelperConfig(AppointmentFindByIdGetway appointmentFindByIdGetway
            ,AppointmentSaveGetway appointmentSaveGetway,DisponibilitySaveGetway disponibilitySaveGetway){
        return new RescheduleAppointmentHelper(appointmentFindByIdGetway,
                appointmentSaveGetway, disponibilitySaveGetway);
    }
    @Bean
    public RescheduleAppointmentUseCase rescheduleAppointmentUseCaseConfig(RescheduleAppointmentGetway rescheduleAppointmentGetyaw
            , RescheduleAppointmentHelper rescheduleAppointmentHelper){
        return new RescheduleAppointmentUseCase(rescheduleAppointmentGetyaw, rescheduleAppointmentHelper);
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
