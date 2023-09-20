package com.app.appointmentapp.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.entity;

import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public class PendingHourExtendData {
    private Date newHour;

    public Date getNewHour() {
        return newHour;
    }

    public void setNewHour(Date newHour) {
        this.newHour = newHour;
    }

    public PendingHourExtendData(Date newHour) {
        this.newHour = newHour;
    }

}
