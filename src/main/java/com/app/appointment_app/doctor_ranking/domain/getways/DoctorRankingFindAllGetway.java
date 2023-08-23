package com.app.appointment_app.doctor_ranking.domain.getways;

import com.app.appointment_app.doctor_ranking.domain.model.DoctorRanking;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DoctorRankingFindAllGetway {
    Page<DoctorRanking> findAllPaginator(int numberPage);

    List<DoctorRanking> findAll();
}
