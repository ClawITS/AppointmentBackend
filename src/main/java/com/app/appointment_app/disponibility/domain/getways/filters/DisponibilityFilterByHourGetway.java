package com.app.appointment_app.disponibility.domain.getways.filters;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.requests.DisponibilityFilterByHourRequest;

import java.util.List;

public interface DisponibilityFilterByHourGetway {
    List<Disponibility>filterByHour(DisponibilityFilterByHourRequest doctorFilterByHourRequest);
}
