package com.app.appointment_app.appointment.domain.usecases;

import com.app.appointment_app.appointment.domain.getways.AppointmentSaveGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.appointment.domain.responses.SaveAppointmentResponse;
import com.app.appointment_app.appointment.domain.usecases.helpers.AppointmentSaveHelper;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.model.enums.DisponibilityState;
import com.app.appointment_app.patient.domain.model.Patient;

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
