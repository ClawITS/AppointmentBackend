package com.app.appointmentapp.disponibility.application.config;

import com.app.appointmentapp.disponibility.domain.getways.cruds.DisponibilityDeleteByIdGetway;
import com.app.appointmentapp.disponibility.domain.getways.cruds.DisponibilityFindAllGetway;
import com.app.appointmentapp.disponibility.domain.getways.cruds.DisponibilityFindByIdGetway;
import com.app.appointmentapp.disponibility.domain.getways.cruds.DisponibilitySaveGetway;
import com.app.appointmentapp.disponibility.domain.getways.filters.DisponibilityFilterByDoctorAndHourGetway;
import com.app.appointmentapp.disponibility.domain.getways.filters.DisponibilityFilterByHourGetway;
import com.app.appointmentapp.disponibility.domain.usecases.filters.DisponibilityFilterByDoctorAndHourUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.filters.DisponibilityFilterByHourUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.cruds.DisponibilityDeleteUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.cruds.DisponibilityFindAllUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.cruds.DisponibilityFindByIdUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.cruds.DisponibilitySaveUseCase;
import com.app.appointmentapp.disponibility.domain.usecases.helpers.DisponibilitySaveHelper;
import com.app.appointmentapp.disponibility.domain.usecases.mappers.SaveDisponibilityResponseMapper;
import com.app.appointmentapp.doctor.domain.getways.cruds.DoctorFindByIdGetway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DisponibilityUseCaseConfig {
    @Bean
    public SaveDisponibilityResponseMapper disponibilityResponseMapperConfig(){
        return new SaveDisponibilityResponseMapper();
    }
    @Bean
    public DisponibilityFilterByDoctorAndHourUseCase disponibilityFilterByDoctorAndHourUseCase(DisponibilityFilterByDoctorAndHourGetway disponibilityFilterByDoctorAndHourGetway){
        return new DisponibilityFilterByDoctorAndHourUseCase(disponibilityFilterByDoctorAndHourGetway);
    }
    @Bean
    public DisponibilityFilterByHourUseCase disponibilityFilterByHourUseCaseConfig(DisponibilityFilterByHourGetway disponibilityFilterByHourGetway){
        return new DisponibilityFilterByHourUseCase(disponibilityFilterByHourGetway);
    }
    @Bean
    public DisponibilitySaveHelper disponibilitySaveHelperConfig(DoctorFindByIdGetway doctorFindByIdGetway){
        return new DisponibilitySaveHelper(doctorFindByIdGetway);
    }
    @Bean
    public DisponibilitySaveUseCase disponibilitySaveUseCaseConfig(DisponibilitySaveGetway disponibilitySaveGetway
            , DisponibilitySaveHelper disponibilitySaveHelper
            , SaveDisponibilityResponseMapper saveDisponibilityResponseMapper){
        return new DisponibilitySaveUseCase(disponibilitySaveGetway, disponibilitySaveHelper, saveDisponibilityResponseMapper);

    }
    @Bean
    public DisponibilityDeleteUseCase disponibilityDeleteUseCaseConfig(
            DisponibilityDeleteByIdGetway disponibilityDeleteByIdGetway){
        return new DisponibilityDeleteUseCase(disponibilityDeleteByIdGetway);

    }
    @Bean
    public DisponibilityFindByIdUseCase disponibilityFindByIdUseCaseConfig(DisponibilityFindByIdGetway
                                                                           disponibilityFindByIdGetway){
        return new DisponibilityFindByIdUseCase(disponibilityFindByIdGetway);

    }
    @Bean
    public DisponibilityFindAllUseCase disponibilityFindAllUseCase(DisponibilityFindAllGetway
                                                                   disponibilityFindAllGetway){
        return new DisponibilityFindAllUseCase(disponibilityFindAllGetway);

    }

}
