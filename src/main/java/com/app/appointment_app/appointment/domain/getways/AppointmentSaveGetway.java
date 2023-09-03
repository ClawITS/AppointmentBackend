package com.app.appointment_app.appointment.domain.getways;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.responses.SaveAppointmentResponse;

public interface AppointmentSaveGetway {
    SaveAppointmentResponse save(Appointment appointment);
}
