package com.app.appointment_app.doctor.domain.getways;

import com.app.appointment_app.appointment.domain.model.Appointment;

public interface RescheduleAppointmentGetyaw {
    Appointment rescheduleAppointment(Appointment appointment);
}
