package com.app.appointmentapp.patient.infraestructure.adapter.db.sql.mysql.jpa_repository;

import com.app.appointmentapp.patient.infraestructure.adapter.db.sql.mysql.entity.PatientData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<PatientData, Long> {
    List<PatientData> findByNameContaining(String nombre);

}
