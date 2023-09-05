package com.app.appointment_app.patient.domain.getways;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.patient.domain.responses.PatientRescheduleResponse;

public interface PatientRescheduleGetway {
    PatientRescheduleResponse patientRescheduleGetway(Appointment appointment);

}
