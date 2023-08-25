package com.app.appointment_app.doctor.domain.useCases;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.doctor.domain.getways.RescheduleAppointmentGetyaw;

public class RescheduleAppointmentUseCase {
    private final RescheduleAppointmentGetyaw rescheduleAppointmentGetyaw;

    public RescheduleAppointmentUseCase(RescheduleAppointmentGetyaw rescheduleAppointmentGetyaw) {
        this.rescheduleAppointmentGetyaw = rescheduleAppointmentGetyaw;
    }

    public Appointment rescheduleAppointment(Appointment appointment){
        appointment.setState(State.EARRING);
        return rescheduleAppointmentGetyaw.rescheduleAppointment(appointment);
    }
}
