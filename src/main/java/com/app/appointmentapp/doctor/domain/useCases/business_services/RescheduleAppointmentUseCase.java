package com.app.appointmentapp.doctor.domain.useCases.business_services;

import com.app.appointmentapp.appointment.domain.model.enums.State;
import com.app.appointmentapp.doctor.domain.getways.business_services.RescheduleAppointmentGetway;
import com.app.appointmentapp.doctor.domain.dto.requests.RescheduleAppointmentRequest;
import com.app.appointmentapp.doctor.domain.dto.response.RescheduleAppointmentResponse;
import com.app.appointmentapp.doctor.domain.useCases.helpers.RescheduleAppointmentHelper;

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
