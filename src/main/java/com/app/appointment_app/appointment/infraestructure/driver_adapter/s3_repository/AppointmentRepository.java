package com.app.appointment_app.appointment.infraestructure.driver_adapter.s3_repository;

import com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository.AppointmentData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentData, Long> {
}
