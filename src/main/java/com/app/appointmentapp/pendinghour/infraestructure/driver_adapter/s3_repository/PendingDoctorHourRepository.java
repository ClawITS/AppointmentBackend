package com.app.appointmentapp.pendinghour.infraestructure.driver_adapter.s3_repository;

import com.app.appointmentapp.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.entity.PendingHourDoctorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PendingDoctorHourRepository extends JpaRepository<PendingHourDoctorData, Long> {
}
