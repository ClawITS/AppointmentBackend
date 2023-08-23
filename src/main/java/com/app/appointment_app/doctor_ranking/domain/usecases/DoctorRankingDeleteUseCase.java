package com.app.appointment_app.doctor_ranking.domain.usecases;

import com.app.appointment_app.doctor_ranking.domain.getways.DoctorRankingDeleteGetway;

public class DoctorRankingDeleteUseCase {
    private final DoctorRankingDeleteGetway doctorRankingDeleteGetway;

    public DoctorRankingDeleteUseCase(DoctorRankingDeleteGetway doctorRankingDeleteGetway) {
        this.doctorRankingDeleteGetway = doctorRankingDeleteGetway;
    }

    public void deleteDoctorRankingById(Long id) {
        doctorRankingDeleteGetway.deleteById(id);
    }
}
