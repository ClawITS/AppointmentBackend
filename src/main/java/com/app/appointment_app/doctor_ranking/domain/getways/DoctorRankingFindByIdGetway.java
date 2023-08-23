package com.app.appointment_app.doctor_ranking.domain.getways;

import com.app.appointment_app.doctor_ranking.domain.model.DoctorRanking;

public interface DoctorRankingFindByIdGetway {
    DoctorRanking findById(Long id);
}
