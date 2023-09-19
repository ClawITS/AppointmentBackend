package com.app.appointment_app.doctor.domain.getways.business_services;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.doctor.domain.dto.response.AcceptPatientReschedulingResponse;

public interface AcceptPatientReschedulingGetway {

    AcceptPatientReschedulingResponse acceptPatientRescheduling(Appointment appointment);

}
