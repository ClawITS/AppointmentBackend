package com.app.appointmentapp.pendinghour.domain.getways.factories;
import java.util.Optional;

public interface CreatePendingHourFactoryGetway {
    Optional<?> createPendingHour(Object object, PendingHourTypeToCreate type);
}
