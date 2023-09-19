package com.app.appointmentapp.disponibility.domain.getways.filters;

import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.domain.requests.DisponibilityFilterByDoctorAndHourRequest;

import java.util.List;

public interface DisponibilityFilterByDoctorAndHourGetway {
    List<Disponibility>filterByDoctorAndHour(DisponibilityFilterByDoctorAndHourRequest disponibilityFilterByDoctorAndHourRequest);
}
