package com.app.appointmentapp.appointment.domain.getways.cruds;

import com.app.appointmentapp.appointment.domain.model.enums.State;

public interface AppointmentUpdateStateGetway {
    void updateAppointmentState(Long idAppointment, State newState);
}
