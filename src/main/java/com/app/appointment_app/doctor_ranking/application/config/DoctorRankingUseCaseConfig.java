package com.app.appointment_app.doctor_ranking.application.config;

import com.app.appointment_app.doctor_ranking.domain.getways.*;
import com.app.appointment_app.doctor_ranking.domain.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoctorRankingUseCaseConfig {
    @Bean
    public DoctorRankingSaveUseCase doctorRankingSaveUseCaseConfig(DoctorRankingSaveGetway doctorRankingSaveGetway) {
        return new DoctorRankingSaveUseCase((doctorRankingSaveGetway));
    }

    @Bean
    public DoctorRankingDeleteUseCase doctorRankingDeleteUseCaseConfig(DoctorRankingDeleteGetway doctorRankingDeleteGetway) {
        return new DoctorRankingDeleteUseCase((doctorRankingDeleteGetway));
    }

    @Bean
    public DoctorRankingFindByIdUseCase doctorRankingFindByIdUseCaseConfig(DoctorRankingFindByIdGetway doctorRankingFindByIdGetway) {
        return new DoctorRankingFindByIdUseCase((doctorRankingFindByIdGetway));
    }

    @Bean
    public DoctorRankingFindAllUseCase doctorRankingFindAllUseCaseConfig(DoctorRankingFindAllGetway doctorRankingFindAllGetway) {
        return new DoctorRankingFindAllUseCase((doctorRankingFindAllGetway));
    }
}
