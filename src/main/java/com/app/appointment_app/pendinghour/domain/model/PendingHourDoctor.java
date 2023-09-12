package com.app.appointment_app.pendinghour.domain.model;

import java.util.Date;

public class PendingHourDoctor extends PendingHourExtend {
    private Long idDoctorPendingHour;

    public PendingHourDoctor(Date newHour, Long idDoctorPendingHour) {
        super(newHour);
        this.idDoctorPendingHour = idDoctorPendingHour;
    }

    @Override
    public String toString() {
        return "PendingHourDoctor{" +
                "idDoctorPendingHour=" + idDoctorPendingHour +
                '}';
    }

    public Long getIdDoctorPendingHour() {
        return idDoctorPendingHour;
    }

    public void setIdDoctorPendingHour(Long idDoctorPendingHour) {
        this.idDoctorPendingHour = idDoctorPendingHour;
    }
}
