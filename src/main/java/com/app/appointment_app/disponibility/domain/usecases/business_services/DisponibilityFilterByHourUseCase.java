package com.app.appointment_app.disponibility.domain.usecases.business_services;

import com.app.appointment_app.disponibility.domain.getways.filters.DisponibilityFilterByHourGetway;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.requests.DisponibilityFilterByHourRequest;

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
