package com.app.appointment_app.speciality.infraestructure.driver_adapter.s3_repository;

import com.app.appointment_app.speciality.infraestructure.driver_adapter.jpa_repository.SpecialityData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends JpaRepository<SpecialityData, Long> {
}
