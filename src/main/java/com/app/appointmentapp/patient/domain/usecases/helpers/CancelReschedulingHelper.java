package com.app.appointmentapp.patient.domain.usecases.helpers;

import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentSaveGetway;
import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.disponibility.domain.getways.cruds.DisponibilitySaveGetway;
import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.domain.model.enums.DisponibilityState;
import com.app.appointmentapp.patient.domain.requests.CancelReschedulingRequest;

public class CancelReschedulingHelper {
    private final AppointmentSaveGetway appointmentSaveGetway;
    private final AppointmentFindByIdGetway appointmentFindByIdGetway;
    private final DisponibilitySaveGetway disponibilitySaveGetway;

    public CancelReschedulingHelper(AppointmentSaveGetway appointmentSaveGetway, AppointmentFindByIdGetway appointmentFindByIdGetway, DisponibilitySaveGetway disponibilitySaveGetway) {
        this.appointmentSaveGetway = appointmentSaveGetway;
        this.appointmentFindByIdGetway = appointmentFindByIdGetway;
        this.disponibilitySaveGetway = disponibilitySaveGetway;
    }

    public void cancelRescheduling(CancelReschedulingRequest cancelReschedulingRequest){
       Appointment appointment = appointmentFindByIdGetway.findById(cancelReschedulingRequest.getIdAppointment());
       appointment.setState(cancelReschedulingRequest.getState());
       appointmentSaveGetway.save(appointment);
       cancelDisponibility(appointment.getDisponibility());
    }
    public void cancelDisponibility(Disponibility disponibility){
        disponibility.setDisponibilityState(DisponibilityState.CANCELED);
        disponibilitySaveGetway.save(disponibility);
    }
}