package com.app.appointment_app.doctor_ranking.domain.getways;

import com.app.appointment_app.doctor_ranking.domain.model.DoctorRanking;

public interface DoctorRankingSaveGetway {
    DoctorRanking save(DoctorRanking doctorRanking);
}
