package com.app.appointmentapp.patient.domain.getways.business_services;

import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.patient.domain.responses.PatientRescheduleResponse;

public interface PatientRescheduleGetway {
    PatientRescheduleResponse patientRescheduleGetway(Appointment appointment);

}
