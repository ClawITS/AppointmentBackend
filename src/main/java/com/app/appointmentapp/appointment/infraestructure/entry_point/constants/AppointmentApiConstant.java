package com.app.appointmentapp.appointment.infraestructure.entry_point.constants;
import static com.app.appointmentapp.commons.infraestructure.rest.entry_points.constants.GlobalApiConstant.INIT_START_API;

public class AppointmentApiConstant {
    private AppointmentApiConstant() {}
    public static final String REQUEST_APPOINTMENT = INIT_START_API +"appointments";
    public static final String CLOSE_APPOINTMENT = "/closeAppointment";
}
