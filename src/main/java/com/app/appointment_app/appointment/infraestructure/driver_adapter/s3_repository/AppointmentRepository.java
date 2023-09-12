package com.app.appointment_app.appointment.infraestructure.driver_adapter.s3_repository;

import com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository.AppointmentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppointmentRepository extends JpaRepository<AppointmentData, Long> {
}
