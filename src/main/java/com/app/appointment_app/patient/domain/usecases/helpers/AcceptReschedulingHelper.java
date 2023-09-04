package com.app.appointment_app.patient.domain.usecases.helpers;

import com.app.appointment_app.appointment.domain.getways.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.getways.AppointmentSaveGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.patient.domain.requests.AcceptReschedulingRequest;

public class AcceptReschedulingHelper {
    private final AppointmentSaveGetway appointmentSaveGetway;
    private final AppointmentFindByIdGetway appointmentFindByIdGetway;

    public AcceptReschedulingHelper(AppointmentSaveGetway appointmentSaveGetway, AppointmentFindByIdGetway appointmentFindByIdGetway) {
        this.appointmentSaveGetway = appointmentSaveGetway;
        this.appointmentFindByIdGetway = appointmentFindByIdGetway;
    }
    public void acceptRescheduling(AcceptReschedulingRequest acceptReschedulingRequest){
        Appointment appointment = appointmentFindByIdGetway.findById(acceptReschedulingRequest.getIdAppointment());
        appointment.setState(acceptReschedulingRequest.getState());
        appointmentSaveGetway.save(appointment);
    }
}
