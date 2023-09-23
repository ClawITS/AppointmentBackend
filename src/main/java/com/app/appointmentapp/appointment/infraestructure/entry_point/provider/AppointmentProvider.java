package com.app.appointmentapp.appointment.infraestructure.entry_point.provider;

import com.app.appointmentapp.appointment.domain.usecases.business_services.CloseAppointmentUseCase;
import com.app.appointmentapp.appointment.domain.usecases.cruds.AppointmentDeleteUseCase;
import com.app.appointmentapp.appointment.domain.usecases.cruds.AppointmentFindAllUseCase;
import com.app.appointmentapp.appointment.domain.usecases.cruds.AppointmentFindByIdUseCase;
import com.app.appointmentapp.appointment.domain.usecases.cruds.AppointmentSaveUseCase;

public interface AppointmentProvider {
    AppointmentSaveUseCase getAppointmentSaveUseCase();
    AppointmentFindAllUseCase getAppointmentFindAllUseCase();
    AppointmentFindByIdUseCase getAppointmentFindByIdUseCase();
    AppointmentDeleteUseCase getAppointmentDeleteUseCase();
    CloseAppointmentUseCase getCloseAppointmentUseCase();
}