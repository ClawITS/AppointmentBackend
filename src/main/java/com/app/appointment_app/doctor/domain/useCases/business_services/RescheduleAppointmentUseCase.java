package com.app.appointment_app.doctor.domain.useCases.business_services;

import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.doctor.domain.getways.business_services.RescheduleAppointmentGetway;
import com.app.appointment_app.doctor.domain.requests.RescheduleAppointmentRequest;
import com.app.appointment_app.doctor.domain.responses.RescheduleAppointmentResponse;
import com.app.appointment_app.doctor.domain.useCases.helpers.RescheduleAppointmentHelper;

public class RescheduleAppointmentUseCase {
    private final RescheduleAppointmentGetway rescheduleAppointmentGetyaw;
    private final RescheduleAppointmentHelper rescheduleAppointmentHelper;

    public RescheduleAppointmentUseCase(RescheduleAppointmentGetway rescheduleAppointmentGetyaw, RescheduleAppointmentHelper rescheduleAppointmentHelper) {
        this.rescheduleAppointmentGetyaw = rescheduleAppointmentGetyaw;
        this.rescheduleAppointmentHelper = rescheduleAppointmentHelper;
    }

    public RescheduleAppointmentResponse rescheduleAppointment(RescheduleAppointmentRequest rescheduleAppointmentRequest){
        rescheduleAppointmentRequest.setState(State.EARRING);
        rescheduleAppointmentHelper.rescheduleAppointment(rescheduleAppointmentRequest);
        return rescheduleAppointmentGetyaw.rescheduleAppointment(rescheduleAppointmentRequest);
    }
}
