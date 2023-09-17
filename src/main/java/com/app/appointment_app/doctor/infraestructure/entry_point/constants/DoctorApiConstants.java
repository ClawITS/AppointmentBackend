package com.app.appointment_app.doctor.infraestructure.entry_point.constants;

import static com.app.appointment_app.commons.infraestructure.rest.entry_points.constants.GlobalApiConstant.INIT_START_API;

public class DoctorApiConstants {
    public static final String REQUEST_DOCTOR = INIT_START_API +"doctors";
    public static final String RESCHEDULE_APPOINTMENT = "/rescheduleAppointment";
    public static final String ACCEPT_RESCHEDULE_APPOINTMENT = "/acceptRescheduling";

}
