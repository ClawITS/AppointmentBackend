package com.app.appointment_app.doctor_ranking.infraestructure.driver_adapter.s3_repository;

import com.app.appointment_app.doctor_ranking.infraestructure.driver_adapter.jpa_repository.DoctorRankingData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRankingRepository extends JpaRepository<DoctorRankingData, Long> {
}
