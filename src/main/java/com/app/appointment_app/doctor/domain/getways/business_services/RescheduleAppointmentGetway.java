package com.app.appointment_app.doctor.domain.getways.business_services;

import com.app.appointment_app.doctor.domain.requests.RescheduleAppointmentRequest;
import com.app.appointment_app.doctor.domain.responses.RescheduleAppointmentResponse;

public interface RescheduleAppointmentGetway {
    RescheduleAppointmentResponse rescheduleAppointment(RescheduleAppointmentRequest rescheduleAppointmentRequest);
}
