package com.app.appointment_app.doctor_ranking.domain.usecases;

import com.app.appointment_app.doctor_ranking.domain.getways.DoctorRankingFindAllGetway;
import com.app.appointment_app.doctor_ranking.domain.model.DoctorRanking;
import org.springframework.data.domain.Page;

import java.util.List;

public class DoctorRankingFindAllUseCase {

    private final DoctorRankingFindAllGetway doctorRankingFindAllGetway;

    public DoctorRankingFindAllUseCase(DoctorRankingFindAllGetway doctorRankingFindAllGetway) {
        this.doctorRankingFindAllGetway = doctorRankingFindAllGetway;
    }

    public Page<DoctorRanking> findAllDoctorRankingPaginator(int numberPage) {
        return doctorRankingFindAllGetway.findAllPaginator(numberPage);
    }

    public List<DoctorRanking> findAll() {
        return doctorRankingFindAllGetway.findAll();
    }
}
