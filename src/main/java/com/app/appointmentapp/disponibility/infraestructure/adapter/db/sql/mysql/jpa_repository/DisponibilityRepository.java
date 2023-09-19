package com.app.appointmentapp.disponibility.infraestructure.adapter.db.sql.mysql.jpa_repository;

import com.app.appointmentapp.disponibility.infraestructure.adapter.db.sql.mysql.entity.DisponibilityData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DisponibilityRepository extends JpaRepository<DisponibilityData, Long> {
    @Query("SELECT d FROM disponibilities d WHERE d.hour BETWEEN :startDate AND :endDate")
    List<DisponibilityData> findByHourRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT d FROM disponibilities d " +
            "WHERE d.doctor.idDoctor = :doctorId " +
            "AND d.hour BETWEEN :startDate AND :endDate")
    List<DisponibilityData> findByDoctorIdAndHourRange(
            @Param("doctorId") Long doctorId,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate

    );
}
