package com.app.appointment_app.doctor.infraestructure.driver_adapter.s3_repository;

import com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository.DoctorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorData, Long> {
}
