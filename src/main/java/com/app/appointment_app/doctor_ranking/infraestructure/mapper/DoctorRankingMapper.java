package com.app.appointment_app.doctor_ranking.infraestructure.mapper;

import com.app.appointment_app.doctor_ranking.domain.model.DoctorRanking;
import com.app.appointment_app.doctor_ranking.infraestructure.driver_adapter.jpa_repository.DoctorRankingData;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class DoctorRankingMapper {

    public DoctorRanking toDoctorRanking(DoctorRankingData doctorRankingData){
        return new DoctorRanking(doctorRankingData.getIdDoctorRanking(),doctorRankingData.getCommentary(),
                doctorRankingData.getRating());
    }

    public DoctorRankingData toData(DoctorRanking doctorRanking){
        return new DoctorRankingData(doctorRanking.getIdDoctorRanking(),doctorRanking.getCommentary(),
                doctorRanking.getRating());
    }
}
