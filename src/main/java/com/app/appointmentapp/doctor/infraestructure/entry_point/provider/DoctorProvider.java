package com.app.appointmentapp.doctor.infraestructure.entry_point.provider;

import com.app.appointmentapp.doctor.domain.useCases.business_services.AcceptPatientReschedulingUseCase;
import com.app.appointmentapp.doctor.domain.useCases.business_services.RescheduleAppointmentUseCase;
import com.app.appointmentapp.doctor.domain.useCases.cruds.DoctorDeleteUseCase;
import com.app.appointmentapp.doctor.domain.useCases.cruds.DoctorFindAllUseCase;
import com.app.appointmentapp.doctor.domain.useCases.cruds.DoctorFindByIdUseCase;
import com.app.appointmentapp.doctor.domain.useCases.cruds.DoctorSaveUseCase;

public interface DoctorProvider {
    DoctorSaveUseCase getDoctorSaveUseCase();
    DoctorDeleteUseCase getDoctorDeleteUseCase();
    DoctorFindByIdUseCase getDoctorFindByIdUseCase();
    DoctorFindAllUseCase getDoctorFindAllUseCase();
    RescheduleAppointmentUseCase getRescheduleAppointmentUseCase();
    AcceptPatientReschedulingUseCase getAcceptPatientReschedulingUseCase();
}
