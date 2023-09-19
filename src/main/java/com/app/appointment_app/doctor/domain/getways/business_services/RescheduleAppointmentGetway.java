package com.app.appointment_app.doctor.domain.getways.business_services;

import com.app.appointment_app.doctor.domain.dto.requests.RescheduleAppointmentRequest;
import com.app.appointment_app.doctor.domain.dto.response.RescheduleAppointmentResponse;

public interface RescheduleAppointmentGetway {
    RescheduleAppointmentResponse rescheduleAppointment(RescheduleAppointmentRequest rescheduleAppointmentRequest);
}
