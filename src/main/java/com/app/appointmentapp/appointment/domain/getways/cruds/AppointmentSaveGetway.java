package com.app.appointmentapp.appointment.domain.getways.cruds;
import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.appointment.domain.dto.responses.SaveAppointmentResponse;

public interface AppointmentSaveGetway {
    SaveAppointmentResponse save(Appointment appointment);
}
