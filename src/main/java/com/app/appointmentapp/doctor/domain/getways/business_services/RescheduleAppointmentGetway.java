package com.app.appointmentapp.doctor.domain.getways.business_services;

import com.app.appointmentapp.doctor.domain.dto.requests.RescheduleAppointmentRequest;
import com.app.appointmentapp.doctor.domain.dto.response.RescheduleAppointmentResponse;

public interface RescheduleAppointmentGetway {
    RescheduleAppointmentResponse rescheduleAppointment(RescheduleAppointmentRequest rescheduleAppointmentRequest);
}
