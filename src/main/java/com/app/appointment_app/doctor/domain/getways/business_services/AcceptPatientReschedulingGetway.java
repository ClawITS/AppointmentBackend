package com.app.appointment_app.doctor.domain.getways.business_services;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.doctor.domain.responses.AcceptPatientReschedulingResponse;

public interface AcceptPatientReschedulingGetway {

    AcceptPatientReschedulingResponse acceptPatientRescheduling(Appointment appointment);

}
