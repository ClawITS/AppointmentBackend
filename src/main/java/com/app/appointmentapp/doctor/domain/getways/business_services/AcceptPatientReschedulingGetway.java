package com.app.appointmentapp.doctor.domain.getways.business_services;

import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.doctor.domain.dto.response.AcceptPatientReschedulingResponse;

public interface AcceptPatientReschedulingGetway {

    AcceptPatientReschedulingResponse acceptPatientRescheduling(Appointment appointment);

}
