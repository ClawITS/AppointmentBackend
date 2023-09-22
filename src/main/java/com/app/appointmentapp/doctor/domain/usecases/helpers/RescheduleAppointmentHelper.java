package com.app.appointmentapp.doctor.domain.usecases.helpers;
import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentUpdateStateGetway;
import com.app.appointmentapp.doctor.domain.dto.requests.RescheduleAppointmentRequest;
import com.app.appointmentapp.pendinghour.domain.getways.factories.CreatePendingHourFactoryGetway;
import com.app.appointmentapp.pendinghour.domain.getways.factories.PendingHourTypeToCreate;
import com.app.appointmentapp.pendinghour.domain.model.PendingHourDoctor;
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
