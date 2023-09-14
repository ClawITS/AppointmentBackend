package com.app.appointment_app.patient.domain.usecases.helpers;

import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentSaveGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilitySaveGetway;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.patient.domain.requests.PatientRescheduleRequest;
import com.app.appointment_app.pendinghour.domain.getways.factories.CreatePendingHourFactoryGetway;
import com.app.appointment_app.pendinghour.domain.getways.factories.PendingHourTypeToCreate;
import com.app.appointment_app.pendinghour.domain.model.PendingHourDoctor;

import java.util.Date;

public class PatientRescheduleHelper {
    private final AppointmentSaveGetway appointmentSaveGetway;
    private final AppointmentFindByIdGetway appointmentFindByIdGetway;
    private final DisponibilitySaveGetway disponibilitySaveGetway;
    private final CreatePendingHourFactoryGetway createPendingHourFactoryGetway;

    public PatientRescheduleHelper(AppointmentSaveGetway appointmentSaveGetway, AppointmentFindByIdGetway appointmentFindByIdGetway, DisponibilitySaveGetway disponibilitySaveGetway, CreatePendingHourFactoryGetway createPendingHourFactoryGetway) {
        this.appointmentSaveGetway = appointmentSaveGetway;
        this.appointmentFindByIdGetway = appointmentFindByIdGetway;
        this.disponibilitySaveGetway = disponibilitySaveGetway;
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
