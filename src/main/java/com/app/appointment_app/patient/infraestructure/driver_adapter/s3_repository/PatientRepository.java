package com.app.appointment_app.patient.infraestructure.driver_adapter.s3_repository;

import com.app.appointment_app.patient.infraestructure.driver_adapter.jpa_repository.PatientData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<PatientData, Long> {
    List<PatientData> findByNameContaining(String nombre);

}
