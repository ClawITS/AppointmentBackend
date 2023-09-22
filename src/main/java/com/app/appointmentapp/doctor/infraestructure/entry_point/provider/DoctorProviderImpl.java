package com.app.appointmentapp.doctor.infraestructure.entry_point.provider;

import com.app.appointmentapp.doctor.domain.usecases.business_services.AcceptPatientReschedulingUseCase;
import com.app.appointmentapp.doctor.domain.usecases.business_services.RescheduleAppointmentUseCase;
import com.app.appointmentapp.doctor.domain.usecases.cruds.DoctorDeleteUseCase;
import com.app.appointmentapp.doctor.domain.usecases.cruds.DoctorFindAllUseCase;
import com.app.appointmentapp.doctor.domain.usecases.cruds.DoctorFindByIdUseCase;
import com.app.appointmentapp.doctor.domain.usecases.cruds.DoctorSaveUseCase;
import com.app.appointmentapp.doctor.infraestructure.entry_point.dto.mapper.DoctorFindedMapper;
import org.springframework.stereotype.Component;

@Component
public class DoctorProviderImpl implements DoctorProvider{
    private final DoctorSaveUseCase doctorSaveUseCase;
    private final DoctorDeleteUseCase doctorDeleteUseCase;
    private final DoctorFindByIdUseCase doctorFindByIdUseCase;
    private final DoctorFindAllUseCase doctorFindAllUseCase;
    private final RescheduleAppointmentUseCase rescheduleAppointmentUseCase;
    private final AcceptPatientReschedulingUseCase acceptPatientReschedulingUseCase;
    private final DoctorFindedMapper doctorFindedMapper;

    public DoctorProviderImpl(DoctorSaveUseCase doctorSaveUseCase, DoctorDeleteUseCase doctorDeleteUseCase, DoctorFindByIdUseCase doctorFindByIdUseCase, DoctorFindAllUseCase doctorFindAllUseCase, RescheduleAppointmentUseCase rescheduleAppointmentUseCase, AcceptPatientReschedulingUseCase acceptPatientReschedulingUseCase, DoctorFindedMapper doctorFindedMapper) {
        this.doctorSaveUseCase = doctorSaveUseCase;
        this.doctorDeleteUseCase = doctorDeleteUseCase;
        this.doctorFindByIdUseCase = doctorFindByIdUseCase;
        this.doctorFindAllUseCase = doctorFindAllUseCase;
        this.rescheduleAppointmentUseCase = rescheduleAppointmentUseCase;
        this.acceptPatientReschedulingUseCase = acceptPatientReschedulingUseCase;
        this.doctorFindedMapper = doctorFindedMapper;
    }

    @Override
    public DoctorSaveUseCase getDoctorSaveUseCase() {
        return doctorSaveUseCase;
    }

    @Override
    public DoctorDeleteUseCase getDoctorDeleteUseCase() {
        return doctorDeleteUseCase;
    }

    @Override
    public DoctorFindByIdUseCase getDoctorFindByIdUseCase() {
        return doctorFindByIdUseCase;
    }

    @Override
    public DoctorFindAllUseCase getDoctorFindAllUseCase() {
        return doctorFindAllUseCase;
    }

    @Override
    public RescheduleAppointmentUseCase getRescheduleAppointmentUseCase() {
        return rescheduleAppointmentUseCase;
    }

    @Override
    public AcceptPatientReschedulingUseCase getAcceptPatientReschedulingUseCase() {
        return acceptPatientReschedulingUseCase;
    }

    @Override
    public DoctorFindedMapper doctorFindedMapper() {
        return doctorFindedMapper;
    }
}
