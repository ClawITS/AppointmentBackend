package com.app.appointmentapp.doctor.infraestructure.adapter.db.sql.mysql.jpa_repository;

import com.app.appointmentapp.doctor.infraestructure.adapter.db.sql.mysql.entity.DoctorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorData, Long> {
}
