package com.app.appointment_app.doctor.domain.useCases.helpers;

import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentUpdateStateGetway;
import com.app.appointment_app.doctor.domain.dto.requests.RescheduleAppointmentRequest;
import com.app.appointment_app.pendinghour.domain.getways.factories.CreatePendingHourFactoryGetway;
import com.app.appointment_app.pendinghour.domain.getways.factories.PendingHourTypeToCreate;
import com.app.appointment_app.pendinghour.domain.model.PendingHourDoctor;

import java.util.Date;

public class RescheduleAppointmentHelper {

    private final CreatePendingHourFactoryGetway createPendingHourFactoryGetway;

    private final AppointmentUpdateStateGetway appointmentUpdateStateGetway;

    public RescheduleAppointmentHelper(CreatePendingHourFactoryGetway createPendingHourFactoryGetway, AppointmentUpdateStateGetway appointmentUpdateStateGetway) {
        this.createPendingHourFactoryGetway = createPendingHourFactoryGetway;
        this.appointmentUpdateStateGetway = appointmentUpdateStateGetway;
    }


    public void rescheduleAppointment(RescheduleAppointmentRequest rescheduleAppointmentRequest){
        createPendingDoctorHour(rescheduleAppointmentRequest.getReschuldeHour());
       updateAppointmentWithNewState(rescheduleAppointmentRequest);
    }

    private void updateAppointmentWithNewState(RescheduleAppointmentRequest rescheduleAppointmentRequest) {
      appointmentUpdateStateGetway.updateAppointmentState(rescheduleAppointmentRequest.getIdAppointment(),
              rescheduleAppointmentRequest.getState());
    }

    private void createPendingDoctorHour(Date newDate) {
        createPendingHourFactoryGetway.createPendingHour(new PendingHourDoctor(newDate, null), PendingHourTypeToCreate.PENDINGHOURDOCTOR);

    }
}
