package com.app.appointment_app.patient.infraestructure.entry_point.provider;

import com.app.appointment_app.patient.domain.usecases.business_services.AcceptReschedulingUseCase;
import com.app.appointment_app.patient.domain.usecases.business_services.CancelReschedulingUseCase;
import com.app.appointment_app.patient.domain.usecases.business_services.PatientResheduleUseCase;
import com.app.appointment_app.patient.domain.usecases.cruds.PatientDeleteUseCase;
import com.app.appointment_app.patient.domain.usecases.cruds.PatientFindAllUseCase;
import com.app.appointment_app.patient.domain.usecases.cruds.PatientFindByIdUseCase;
import com.app.appointment_app.patient.domain.usecases.cruds.PatientSaveUseCase;
import com.app.appointment_app.patient.domain.usecases.filters.PatientFilterByNameUseCase;

public interface PatientProvider {
    PatientResheduleUseCase getPatientResheduleUseCase();
    PatientSaveUseCase getPatientSaveUseCase();
    AcceptReschedulingUseCase getAcceptReschedulingUseCase();
    PatientFindAllUseCase getPatientFindAllUseCase();
    PatientFindByIdUseCase getPatientFindByIdUseCase();
    PatientDeleteUseCase getPatientDeleteUseCase();
    CancelReschedulingUseCase getCancelReschedulingUseCase();
    PatientFilterByNameUseCase getPatientFilterByNameUseCase();
}
