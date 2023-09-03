package com.app.appointment_app.doctor.domain.useCases;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.doctor.domain.getways.RescheduleAppointmentGetway;
import com.app.appointment_app.doctor.domain.requests.RescheduleAppointmentRequest;
import com.app.appointment_app.doctor.domain.responses.RescheduleAppointmentResponse;

public class RescheduleAppointmentUseCase {
    private final RescheduleAppointmentGetway rescheduleAppointmentGetyaw;

    public RescheduleAppointmentUseCase(RescheduleAppointmentGetway rescheduleAppointmentGetyaw) {
        this.rescheduleAppointmentGetyaw = rescheduleAppointmentGetyaw;
    }

    public RescheduleAppointmentResponse rescheduleAppointment(RescheduleAppointmentRequest rescheduleAppointmentRequest){
        rescheduleAppointmentRequest.setState(State.EARRING);
        return rescheduleAppointmentGetyaw.rescheduleAppointment(rescheduleAppointmentRequest);
    }
}
