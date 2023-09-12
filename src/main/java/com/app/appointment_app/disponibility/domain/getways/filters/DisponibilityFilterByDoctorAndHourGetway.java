package com.app.appointment_app.disponibility.domain.getways.filters;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.requests.DisponibilityFilterByDoctorAndHourRequest;

import java.util.List;

public interface DisponibilityFilterByDoctorAndHourGetway {
    List<Disponibility>filterByDoctorAndHour(DisponibilityFilterByDoctorAndHourRequest disponibilityFilterByDoctorAndHourRequest);
}
