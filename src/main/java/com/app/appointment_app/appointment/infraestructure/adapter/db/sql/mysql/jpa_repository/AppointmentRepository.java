package com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.jpa_repository;

import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.appointment.domain.dto.responses.AppointmentFindStateByIdResponse;
import com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.entity.AppointmentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppointmentRepository extends JpaRepository<AppointmentData, Long> {

    @Modifying
    @Query("UPDATE appointments a SET a.state = :newState WHERE a.idAppointment = :appointmentId")
    void updateAppointmentState(@Param("appointmentId") Long appointmentId, @Param("newState") State newState);


}
