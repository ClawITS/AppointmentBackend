package com.app.appointment_app.pendinghour.domain.model;

import java.util.Date;

public abstract class PendingHourExtend {

    private Date newHour;

    public PendingHourExtend( Date newHour) {

        this.newHour = newHour;
    }


    public Date getNewHour() {
        return newHour;
    }

    public void setNewHour(Date newHour) {
        this.newHour = newHour;
    }

}
