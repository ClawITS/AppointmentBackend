package com.app.appointmentapp.disponibility.domain.usecases.filters;

import com.app.appointmentapp.disponibility.domain.getways.filters.DisponibilityFilterByDoctorAndHourGetway;
import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.domain.requests.DisponibilityFilterByDoctorAndHourRequest;

import java.util.List;

public class DisponibilityFilterByDoctorAndHourUseCase {
    private final DisponibilityFilterByDoctorAndHourGetway disponibilityFilterByDoctorAndHourGetway;

    public DisponibilityFilterByDoctorAndHourUseCase(DisponibilityFilterByDoctorAndHourGetway disponibilityFilterByDoctorAndHourGetway) {
        this.disponibilityFilterByDoctorAndHourGetway = disponibilityFilterByDoctorAndHourGetway;
    }


    public List<Disponibility>filterDisponibilittyByDoctorAndHour(DisponibilityFilterByDoctorAndHourRequest disponibilityFilterByDoctorAndHourRequest){
        return disponibilityFilterByDoctorAndHourGetway.filterByDoctorAndHour(disponibilityFilterByDoctorAndHourRequest);
    }
}
