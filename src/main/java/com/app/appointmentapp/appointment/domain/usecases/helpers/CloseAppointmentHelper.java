package com.app.appointmentapp.appointment.domain.usecases.helpers;

import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentSaveGetway;
import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.appointment.domain.dto.requests.CloseAppointmentRequest;
import com.app.appointmentapp.disponibility.domain.getways.cruds.DisponibilitySaveGetway;
import com.app.appointmentapp.disponibility.domain.model.enums.DisponibilityState;

public class CloseAppointmentHelper {
    private final AppointmentFindByIdGetway appointmentFindByIdGetway;
    private final AppointmentSaveGetway appointmentSaveGetway;
    private final DisponibilitySaveGetway disponibilitySaveGetway;

    public CloseAppointmentHelper(AppointmentFindByIdGetway appointmentFindByIdGetway, AppointmentSaveGetway appointmentSaveGetway, DisponibilitySaveGetway disponibilitySaveGetway) {
        this.appointmentFindByIdGetway = appointmentFindByIdGetway;
        this.appointmentSaveGetway = appointmentSaveGetway;
        this.disponibilitySaveGetway = disponibilitySaveGetway;
    }

    public void attendAppointment(CloseAppointmentRequest closeAppointmentRequest){
       Appointment appointment = appointmentFindByIdGetway.findById(closeAppointmentRequest.getIdAppointment());
       appointment.setState(closeAppointmentRequest.getState());
        updateDisponibility(appointment);
        appointmentSaveGetway.save(appointment);
    }

    private void updateDisponibility(Appointment appointment) {
        appointment.getDisponibility().setDisponibilityState(DisponibilityState.CLOSED);
        disponibilitySaveGetway.save(appointment.getDisponibility());
    }
}
