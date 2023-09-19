package com.app.appointmentapp.patient.domain.usecases.helpers;

import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentSaveGetway;
import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.patient.domain.requests.PatientRescheduleRequest;
import com.app.appointmentapp.pendinghour.domain.getways.factories.CreatePendingHourFactoryGetway;
import com.app.appointmentapp.pendinghour.domain.getways.factories.PendingHourTypeToCreate;
import com.app.appointmentapp.pendinghour.domain.model.PendingHourDoctor;

import java.util.Date;

public class PatientRescheduleHelper {
    private final AppointmentSaveGetway appointmentSaveGetway;
    private final AppointmentFindByIdGetway appointmentFindByIdGetway;
    private final CreatePendingHourFactoryGetway createPendingHourFactoryGetway;

    public PatientRescheduleHelper(AppointmentSaveGetway appointmentSaveGetway, AppointmentFindByIdGetway appointmentFindByIdGetway, CreatePendingHourFactoryGetway createPendingHourFactoryGetway) {
        this.appointmentSaveGetway = appointmentSaveGetway;
        this.appointmentFindByIdGetway = appointmentFindByIdGetway;
        this.createPendingHourFactoryGetway = createPendingHourFactoryGetway;
    }


    public Appointment patientRescheduleAppointment(PatientRescheduleRequest patientRescheduleRequest){
      Appointment appointment= appointmentFindByIdGetway.findById(patientRescheduleRequest.getIdAppointment());
      appointment.setState(patientRescheduleRequest.getState());
      appointmentSaveGetway.save(appointment);
      createPendingHour(patientRescheduleRequest.getNewDate());
      return appointment;
    }

    public void createPendingHour( Date newHour){
        createPendingHourFactoryGetway.createPendingHour(
                new PendingHourDoctor(newHour,null)
                , PendingHourTypeToCreate.PENDINGHOURPATIENT);
    }
}
