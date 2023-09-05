package com.app.appointment_app.patient.domain.usecases.helpers;

import com.app.appointment_app.appointment.domain.getways.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.getways.AppointmentSaveGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.patient.domain.requests.PatientRescheduleRequest;

public class PatientRescheduleHelper {
    private final AppointmentSaveGetway appointmentSaveGetway;
    private final AppointmentFindByIdGetway appointmentFindByIdGetway;

    public PatientRescheduleHelper(AppointmentSaveGetway appointmentSaveGetway, AppointmentFindByIdGetway appointmentFindByIdGetway) {
        this.appointmentSaveGetway = appointmentSaveGetway;
        this.appointmentFindByIdGetway = appointmentFindByIdGetway;
    }

    public Appointment patientRescheduleAppointment(PatientRescheduleRequest patientRescheduleRequest){
      Appointment appointment= appointmentFindByIdGetway.findById(patientRescheduleRequest.getIdAppointment());
      appointment.setState(patientRescheduleRequest.getState());
      appointmentSaveGetway.save(appointment);
      return appointment;
    }
}
