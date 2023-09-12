package com.app.appointment_app.pendinghour.domain.model;

import com.app.appointment_app.pendinghour.domain.model.PendingHourExtend;

import java.util.Date;

public class PendingHourPatient extends PendingHourExtend {

    private Long idPatientPendingHour;


    public PendingHourPatient(Date newHour, Long idPatientPendingHour) {
        super(newHour);
        this.idPatientPendingHour = idPatientPendingHour;
    }

    public Long getIdPatientPendingHour() {
        return idPatientPendingHour;
    }

    public void setIdPatientPendingHour(Long idPatientPendingHour) {
        this.idPatientPendingHour = idPatientPendingHour;
    }

    @Override
    public String toString() {
        return "PendingHourPatient{" +
                "idPatientPendingHour=" + idPatientPendingHour +
                '}';
    }
}
