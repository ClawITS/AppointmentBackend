package com.app.appointment_app.appointment.domain.usecases.cruds;
import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentDeleteGetway;

public class AppointmentDeleteUseCase {
    private final AppointmentDeleteGetway appointmentDeleteGetway;

    public AppointmentDeleteUseCase(AppointmentDeleteGetway appointmentDeleteGetway) {
        this.appointmentDeleteGetway = appointmentDeleteGetway;
    }

    public void deleteAppointmentById(Long id) {
        appointmentDeleteGetway.deleteById(id);
    }
}
