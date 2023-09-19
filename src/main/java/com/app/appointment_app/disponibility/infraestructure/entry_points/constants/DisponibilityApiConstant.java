package com.app.appointment_app.disponibility.infraestructure.entry_points.constants;
import static com.app.appointment_app.commons.infraestructure.rest.entry_points.constants.GlobalApiConstant.INIT_START_API;

public class DisponibilityApiConstant {
    public static final String REQUEST_DISPONIBILITY = INIT_START_API +"disponibilities";
    public static final String FILTER_BY_RANGE = "/filter-hour-range";
    public static final String FILTER_BY_DOCTOR_AND_HOUR = "/filter-hour-range-doctor";
}
