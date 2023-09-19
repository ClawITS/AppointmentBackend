package com.app.appointmentapp.appointment.domain.usecases.cruds;

import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentSaveGetway;
import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.appointment.domain.model.enums.State;
import com.app.appointmentapp.appointment.domain.dto.responses.SaveAppointmentResponse;
import com.app.appointmentapp.appointment.domain.usecases.helpers.AppointmentSaveHelper;

public class AppointmentSaveUseCase {
    private final AppointmentSaveGetway appointmentSaveGetway;
    private final AppointmentSaveHelper appointmentSaveHelper;

    public AppointmentSaveUseCase(AppointmentSaveGetway appointmentSaveGetway, AppointmentSaveHelper appointmentSaveHelper) {
        this.appointmentSaveGetway = appointmentSaveGetway;
        this.appointmentSaveHelper = appointmentSaveHelper;
    }


    public SaveAppointmentResponse saveAppointment(Appointment appointment) {
        appointment.setState(State.OPEN);
        appointmentSaveHelper.chargeDisponibilityToAppointment(appointment);
        return appointmentSaveGetway.save(appointment);
    }
}
