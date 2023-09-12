package com.app.appointment_app.appointment.domain.getways.cruds;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.ports.responses.SaveAppointmentResponse;

public interface AppointmentSaveGetway {
    SaveAppointmentResponse save(Appointment appointment);
}
