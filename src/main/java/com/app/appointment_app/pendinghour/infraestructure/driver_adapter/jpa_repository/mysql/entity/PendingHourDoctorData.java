package com.app.appointment_app.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity(name = "doctor_pendings")
public class PendingHourDoctorData extends PendingHourExtendData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoctorPendingHour;

    public PendingHourDoctorData(Date newHour, Long idDoctorPendingHour) {
        super(newHour);
        this.idDoctorPendingHour = idDoctorPendingHour;
    }

    public Long getIdDoctorPendingHour() {
        return idDoctorPendingHour;
    }

    public void setIdDoctorPendingHour(Long idDoctorPendingHour) {
        this.idDoctorPendingHour = idDoctorPendingHour;
    }
}
