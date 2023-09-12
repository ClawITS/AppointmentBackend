package com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.jpa_repository;

import com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.entity.AppointmentData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentData, Long> {
}
