package com.app.appointment_app.appointment.domain.usecases;
import com.app.appointment_app.appointment.domain.getways.AppointmentDeleteGetway;

public class AppointmentDeleteUseCase {
    private final AppointmentDeleteGetway appointmentDeleteGetway;

    public AppointmentDeleteUseCase(AppointmentDeleteGetway appointmentDeleteGetway) {
        this.appointmentDeleteGetway = appointmentDeleteGetway;
    }

    public void deleteAppointmentById(Long id) {
        appointmentDeleteGetway.deleteById(id);
    }
}
