package com.app.appointment_app.disponibility.infraestructure.driver_adapter.s3_repository;

import com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository.DisponibilityData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisponibilityRepository extends JpaRepository<DisponibilityData, Long> {
}
