package com.app.appointmentapp.doctor.domain.useCases.helpers;

import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.appointment.domain.model.enums.State;
import com.app.appointmentapp.doctor.domain.dto.requests.AcceptPatientReschedulingRequest;

public class AcceptPatientReschedulingHelper {
    private final AppointmentFindByIdGetway appointmentFindByIdGetway;

    public AcceptPatientReschedulingHelper(AppointmentFindByIdGetway appointmentFindByIdGetway) {
        this.appointmentFindByIdGetway = appointmentFindByIdGetway;
    }


    public Appointment acceptPatientRescheduling(AcceptPatientReschedulingRequest acceptPatientReschedulingRequest){
        Appointment appointment = appointmentFindByIdGetway.findById(acceptPatientReschedulingRequest.getIdAppointment());
        appointment.setState(State.RESCHEDULED);

        return appointment;
    }

}

