package com.app.appointment_app.doctor.domain.useCases.helpers;

import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentSaveGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.doctor.domain.requests.AcceptPatientReschedulingRequest;

public class AcceptPatientReschedulingHelper {
    private final AppointmentFindByIdGetway appointmentFindByIdGetway;
    private final AppointmentSaveGetway appointmentSaveGetway;

    public AcceptPatientReschedulingHelper(AppointmentFindByIdGetway appointmentFindByIdGetway, AppointmentSaveGetway appointmentSaveGetway) {
        this.appointmentFindByIdGetway = appointmentFindByIdGetway;
        this.appointmentSaveGetway = appointmentSaveGetway;
    }

    public Appointment acceptPatientRescheduling(AcceptPatientReschedulingRequest acceptPatientReschedulingRequest){
        Appointment appointment = appointmentFindByIdGetway.findById(acceptPatientReschedulingRequest.getIdAppointment());
        appointment.setState(State.RESCHEDULED);
        appointmentSaveGetway.save(appointment);
        return appointment;
    }
}

