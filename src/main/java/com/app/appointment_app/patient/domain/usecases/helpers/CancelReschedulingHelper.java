package com.app.appointment_app.patient.domain.usecases.helpers;

import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentSaveGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilitySaveGetway;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.model.enums.DisponibilityState;
import com.app.appointment_app.patient.domain.requests.CancelReschedulingRequest;

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
