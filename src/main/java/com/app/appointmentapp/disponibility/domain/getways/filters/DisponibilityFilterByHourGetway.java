package com.app.appointmentapp.disponibility.domain.getways.filters;

import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.domain.requests.DisponibilityFilterByHourRequest;

import java.util.List;

public interface DisponibilityFilterByHourGetway {
    List<Disponibility>filterByHour(DisponibilityFilterByHourRequest doctorFilterByHourRequest);
}
