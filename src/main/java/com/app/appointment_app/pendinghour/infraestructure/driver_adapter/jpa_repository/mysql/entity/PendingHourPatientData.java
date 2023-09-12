package com.app.appointment_app.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity(name = "patient_pendings")
public class PendingHourPatientData extends PendingHourExtendData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatientPendingHour;

    public PendingHourPatientData(Date newHour, Long idPatientPendingHour) {
        super(newHour);
        this.idPatientPendingHour = idPatientPendingHour;
    }

    public Long getIdPatientPendingHour() {
        return idPatientPendingHour;
    }

    public void setIdPatientPendingHour(Long idPatientPendingHour) {
        this.idPatientPendingHour = idPatientPendingHour;
    }
}
