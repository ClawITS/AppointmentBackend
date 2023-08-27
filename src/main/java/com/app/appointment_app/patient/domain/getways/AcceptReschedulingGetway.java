package com.app.appointment_app.patient.domain.getways;


import com.app.appointment_app.appointment.domain.model.Appointment;

public interface AcceptReschedulingGetway {

    Appointment acceptRescheduling(Appointment appointment);
}
