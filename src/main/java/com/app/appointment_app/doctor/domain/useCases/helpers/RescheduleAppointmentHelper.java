package com.app.appointment_app.doctor.domain.useCases.helpers;

import com.app.appointment_app.appointment.domain.getways.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.getways.AppointmentSaveGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.disponibility.domain.getways.DisponibilitySaveGetway;
import com.app.appointment_app.doctor.domain.requests.RescheduleAppointmentRequest;

public class RescheduleAppointmentHelper {
    private final AppointmentFindByIdGetway appointmentFindByIdGetway;
    private final AppointmentSaveGetway appointmentSaveGetway;
    private final DisponibilitySaveGetway disponibilitySaveGetway;

    public RescheduleAppointmentHelper(AppointmentFindByIdGetway appointmentFindByIdGetway, AppointmentSaveGetway appointmentSaveGetway, DisponibilitySaveGetway disponibilitySaveGetway) {
        this.appointmentFindByIdGetway = appointmentFindByIdGetway;
        this.appointmentSaveGetway = appointmentSaveGetway;
        this.disponibilitySaveGetway = disponibilitySaveGetway;
    }

    public void rescheduleAppointment(RescheduleAppointmentRequest rescheduleAppointmentRequest){
       Appointment appointment = appointmentFindByIdGetway.findById(rescheduleAppointmentRequest.getIdAppointment());
       updateDisponibilityWithNewHour(rescheduleAppointmentRequest, appointment);
       updateAppointmentWithNewState(rescheduleAppointmentRequest, appointment);
    }

    private void updateAppointmentWithNewState(RescheduleAppointmentRequest rescheduleAppointmentRequest, Appointment appointment) {
        appointment.setState(rescheduleAppointmentRequest.getState());
        appointmentSaveGetway.save(appointment);
    }

    private void updateDisponibilityWithNewHour(RescheduleAppointmentRequest rescheduleAppointmentRequest, Appointment appointment) {
        appointment.getDisponibility().setHour(rescheduleAppointmentRequest.getReschuldeHour());
        disponibilitySaveGetway.save(appointment.getDisponibility());
    }
}
