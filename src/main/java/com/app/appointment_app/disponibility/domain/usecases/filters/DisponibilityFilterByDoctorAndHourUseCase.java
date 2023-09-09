package com.app.appointment_app.disponibility.domain.usecases.filters;

import com.app.appointment_app.disponibility.domain.getways.filters.DisponibilityFilterByDoctorAndHourGetway;
import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.requests.DisponibilityFilterByDoctorAndHourRequest;

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
