package com.app.appointment_app.doctor_ranking.domain.usecases;

import com.app.appointment_app.doctor_ranking.domain.getways.DoctorRankingSaveGetway;
import com.app.appointment_app.doctor_ranking.domain.model.DoctorRanking;

public class DoctorRankingSaveUseCase {
    private final DoctorRankingSaveGetway doctorRankingSaveGetway;

    public DoctorRankingSaveUseCase(DoctorRankingSaveGetway doctorRankingSaveGetway) {
        this.doctorRankingSaveGetway = doctorRankingSaveGetway;
    }

    public DoctorRanking saveDoctorRanking(DoctorRanking doctorRanking) {
        return doctorRankingSaveGetway.save(doctorRanking);
    }
}
