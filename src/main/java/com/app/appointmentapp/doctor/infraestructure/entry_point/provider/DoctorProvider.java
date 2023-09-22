package com.app.appointmentapp.doctor.infraestructure.entry_point.provider;

import com.app.appointmentapp.doctor.domain.usecases.business_services.AcceptPatientReschedulingUseCase;
import com.app.appointmentapp.doctor.domain.usecases.business_services.RescheduleAppointmentUseCase;
import com.app.appointmentapp.doctor.domain.usecases.cruds.DoctorDeleteUseCase;
import com.app.appointmentapp.doctor.domain.usecases.cruds.DoctorFindAllUseCase;
import com.app.appointmentapp.doctor.domain.usecases.cruds.DoctorFindByIdUseCase;
import com.app.appointmentapp.doctor.domain.usecases.cruds.DoctorSaveUseCase;
import com.app.appointmentapp.doctor.infraestructure.entry_point.dto.mapper.DoctorFindedMapper;

public interface DoctorProvider {
    DoctorSaveUseCase getDoctorSaveUseCase();
    DoctorDeleteUseCase getDoctorDeleteUseCase();
    DoctorFindByIdUseCase getDoctorFindByIdUseCase();
    DoctorFindAllUseCase getDoctorFindAllUseCase();
    RescheduleAppointmentUseCase getRescheduleAppointmentUseCase();
    AcceptPatientReschedulingUseCase getAcceptPatientReschedulingUseCase();
    DoctorFindedMapper doctorFindedMapper();
}
