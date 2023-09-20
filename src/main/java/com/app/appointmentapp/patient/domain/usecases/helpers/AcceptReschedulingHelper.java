package com.app.appointmentapp.patient.domain.usecases.helpers;

import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentSaveGetway;
import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.patient.domain.requests.AcceptReschedulingRequest;

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
