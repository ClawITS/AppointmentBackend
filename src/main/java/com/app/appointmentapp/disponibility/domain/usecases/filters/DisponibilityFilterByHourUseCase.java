package com.app.appointmentapp.disponibility.domain.usecases.filters;

import com.app.appointmentapp.disponibility.domain.getways.filters.DisponibilityFilterByHourGetway;
import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.domain.requests.DisponibilityFilterByHourRequest;

import java.util.List;

public class DisponibilityFilterByHourUseCase {
    private final DisponibilityFilterByHourGetway disponibilityFilterByHourGetway;

    public DisponibilityFilterByHourUseCase(DisponibilityFilterByHourGetway disponibilityFilterByHourGetway) {
        this.disponibilityFilterByHourGetway = disponibilityFilterByHourGetway;
    }
    public List<Disponibility> findDisponibilitiesByHour(DisponibilityFilterByHourRequest disponibilityFilterByHourRequest){
        return disponibilityFilterByHourGetway.filterByHour(disponibilityFilterByHourRequest);
    }
}
