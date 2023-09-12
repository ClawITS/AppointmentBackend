package com.app.appointment_app.pendinghour.domain.getways.factories;
import java.util.Optional;

public interface CreatePendingHourFactoryGetway {
    Optional<?> createPendingHour(Object object, PendingHourTypeToCreate type);
}
