package com.app.appointment_app.doctor.domain.useCases.helpers;

import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentSaveGetway;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilitySaveGetway;
import com.app.appointment_app.doctor.domain.requests.AcceptPatientReschedulingRequest;

public class AcceptPatientReschedulingHelper {
    private final AppointmentFindByIdGetway appointmentFindByIdGetway;
    private final AppointmentSaveGetway appointmentSaveGetway;

    private final DisponibilitySaveGetway disponibilitySaveGetway;

    public AcceptPatientReschedulingHelper(AppointmentFindByIdGetway appointmentFindByIdGetway, AppointmentSaveGetway appointmentSaveGetway, DisponibilitySaveGetway disponibilitySaveGetway) {
        this.appointmentFindByIdGetway = appointmentFindByIdGetway;
        this.appointmentSaveGetway = appointmentSaveGetway;
        this.disponibilitySaveGetway = disponibilitySaveGetway;
    }

    public Appointment acceptPatientRescheduling(AcceptPatientReschedulingRequest acceptPatientReschedulingRequest){
        Appointment appointment = appointmentFindByIdGetway.findById(acceptPatientReschedulingRequest.getIdAppointment());
        appointment.setState(State.RESCHEDULED);
        /*Long idPending = appointment.getDisponibility().getPendingReschedule()
                .getIdPendingHour();
        updateDisponibilityWithNewHour(appointment.getDisponibility(),appointment.getDisponibility().
                getPendingReschedule().getNewHour());
        appointmentSaveGetway.save(appointment);
        pendingHourDeleteByIdGetway.deleteById(idPending);*/
        return appointment;
    }
   /* public void updateDisponibilityWithNewHour(Disponibility disponibility, Date newDate){
        disponibility.setHour(newDate);
        disponibility.setPendingReschedule(null);
        disponibilitySaveGetway.save(disponibility);

    }*/
}

