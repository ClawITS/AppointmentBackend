package com.app.appointment_app.appointment.domain.getways.cruds;

import com.app.appointment_app.appointment.domain.model.enums.State;

public interface AppointmentUpdateStateGetway {
    void updateAppointmentState(Long idAppointment, State newState);
}
