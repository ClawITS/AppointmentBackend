package com.app.appointmentapp.pendinghour.domain.model;

import java.util.Date;

public abstract class PendingHourExtend {

    private Date newHour;

    protected PendingHourExtend( Date newHour) {

        this.newHour = newHour;
    }


    public Date getNewHour() {
        return newHour;
    }

    public void setNewHour(Date newHour) {
        this.newHour = newHour;
    }

}
