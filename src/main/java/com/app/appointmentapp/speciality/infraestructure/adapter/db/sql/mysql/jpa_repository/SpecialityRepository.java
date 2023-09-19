package com.app.appointmentapp.speciality.infraestructure.adapter.db.sql.mysql.jpa_repository;

import com.app.appointmentapp.speciality.infraestructure.adapter.db.sql.mysql.entity.SpecialityData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends JpaRepository<SpecialityData, Long> {
}
