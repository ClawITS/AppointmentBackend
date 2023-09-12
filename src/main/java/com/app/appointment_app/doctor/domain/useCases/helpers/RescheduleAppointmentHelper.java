package com.app.appointment_app.doctor.domain.useCases.helpers;

import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentSaveGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilitySaveGetway;
import com.app.appointment_app.doctor.domain.requests.RescheduleAppointmentRequest;
import com.app.appointment_app.pendinghour.domain.getways.factories.CreatePendingHourFactoryGetway;
import com.app.appointment_app.pendinghour.domain.getways.factories.PendingHourTypeToCreate;
import com.app.appointment_app.pendinghour.domain.model.PendingHourDoctor;

import java.util.Date;

public class RescheduleAppointmentHelper {
    private final AppointmentFindByIdGetway appointmentFindByIdGetway;
    private final AppointmentSaveGetway appointmentSaveGetway;
    private final DisponibilitySaveGetway disponibilitySaveGetway;
    private final CreatePendingHourFactoryGetway createPendingHourFactoryGetway;

    public RescheduleAppointmentHelper(AppointmentFindByIdGetway appointmentFindByIdGetway, AppointmentSaveGetway appointmentSaveGetway, DisponibilitySaveGetway disponibilitySaveGetway, CreatePendingHourFactoryGetway createPendingHourFactoryGetway) {
        this.appointmentFindByIdGetway = appointmentFindByIdGetway;
        this.appointmentSaveGetway = appointmentSaveGetway;
        this.disponibilitySaveGetway = disponibilitySaveGetway;
        this.createPendingHourFactoryGetway = createPendingHourFactoryGetway;
    }

    public void rescheduleAppointment(RescheduleAppointmentRequest rescheduleAppointmentRequest){
       Appointment appointment = appointmentFindByIdGetway.findById(rescheduleAppointmentRequest.getIdAppointment());
       updateDisponibilityWithNewHour(rescheduleAppointmentRequest.getReschuldeHour(), appointment);
       updateAppointmentWithNewState(rescheduleAppointmentRequest, appointment);
    }

    private void updateAppointmentWithNewState(RescheduleAppointmentRequest rescheduleAppointmentRequest, Appointment appointment) {
        appointment.setState(rescheduleAppointmentRequest.getState());
        appointmentSaveGetway.save(appointment);
    }

    private void updateDisponibilityWithNewHour(Date newDate, Appointment appointment) {
        //appointment.getDisponibility().setPendingReschedule(new PendingHour(null, newDate));
        createPendingHourFactoryGetway.createPendingHour(new PendingHourDoctor(newDate, null), PendingHourTypeToCreate.PENDINGHOURDOCTOR);
        disponibilitySaveGetway.save(appointment.getDisponibility());
    }
}
