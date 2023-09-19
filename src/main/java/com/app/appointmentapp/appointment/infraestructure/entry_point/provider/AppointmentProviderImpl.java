package com.app.appointmentapp.appointment.infraestructure.entry_point.provider;

import com.app.appointmentapp.appointment.domain.usecases.business_services.CloseAppointmentUseCase;
import com.app.appointmentapp.appointment.domain.usecases.cruds.AppointmentDeleteUseCase;
import com.app.appointmentapp.appointment.domain.usecases.cruds.AppointmentFindAllUseCase;
import com.app.appointmentapp.appointment.domain.usecases.cruds.AppointmentFindByIdUseCase;
import com.app.appointmentapp.appointment.domain.usecases.cruds.AppointmentSaveUseCase;
import org.springframework.stereotype.Component;

@Component
public class AppointmentProviderImpl implements AppointmentProvider{
    private final AppointmentSaveUseCase appointmentSaveUseCase;
    private final AppointmentFindAllUseCase appointmentFindAllUseCase;
    private final AppointmentFindByIdUseCase appointmentFindByIdUseCase;
    private final AppointmentDeleteUseCase appointmentDeleteUseCase;
    private final CloseAppointmentUseCase closeAppointmentUseCase;

    public AppointmentProviderImpl(AppointmentSaveUseCase appointmentSaveUseCase, AppointmentFindAllUseCase appointmentFindAllUseCase, AppointmentFindByIdUseCase appointmentFindByIdUseCase, AppointmentDeleteUseCase appointmentDeleteUseCase, CloseAppointmentUseCase closeAppointmentUseCase) {
        this.appointmentSaveUseCase = appointmentSaveUseCase;
        this.appointmentFindAllUseCase = appointmentFindAllUseCase;
        this.appointmentFindByIdUseCase = appointmentFindByIdUseCase;
        this.appointmentDeleteUseCase = appointmentDeleteUseCase;
        this.closeAppointmentUseCase = closeAppointmentUseCase;
    }

    @Override
    public AppointmentSaveUseCase getAppointmentSaveUseCase() {
        return appointmentSaveUseCase;
    }

    @Override
    public AppointmentFindAllUseCase getAppointmentFindAllUseCase() {
        return appointmentFindAllUseCase;
    }

    @Override
    public AppointmentFindByIdUseCase getAppointmentFindByIdUseCase() {
        return appointmentFindByIdUseCase;
    }

    @Override
    public AppointmentDeleteUseCase getAppointmentDeleteUseCase() {
        return appointmentDeleteUseCase;
    }

    @Override
    public CloseAppointmentUseCase getCloseAppointmentUseCase() {
        return closeAppointmentUseCase;
    }
}
