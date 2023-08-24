package com.app.appointment_app.doctor_ranking.domain.usecases;

import com.app.appointment_app.doctor_ranking.domain.getways.DoctorRankingFindAllGetway;
import com.app.appointment_app.doctor_ranking.domain.getways.DoctorRankingFindByIdGetway;
import com.app.appointment_app.doctor_ranking.domain.model.DoctorRanking;

public class DoctorRankingFindByIdUseCase {

    private final DoctorRankingFindByIdGetway doctorRankingFindByIdGetway;

    public DoctorRankingFindByIdUseCase(DoctorRankingFindByIdGetway doctorRankingFindByIdGetway) {
        this.doctorRankingFindByIdGetway = doctorRankingFindByIdGetway;
    }

    public DoctorRanking findDoctorRankingById(Long id) {
        return doctorRankingFindByIdGetway.findById(id);
    }

}
