package com.app.appointmentapp.patient.infraestructure.entry_point.provider;

import com.app.appointmentapp.patient.domain.usecases.business_services.AcceptReschedulingUseCase;
import com.app.appointmentapp.patient.domain.usecases.business_services.CancelReschedulingUseCase;
import com.app.appointmentapp.patient.domain.usecases.business_services.PatientResheduleUseCase;
import com.app.appointmentapp.patient.domain.usecases.cruds.PatientDeleteUseCase;
import com.app.appointmentapp.patient.domain.usecases.cruds.PatientFindAllUseCase;
import com.app.appointmentapp.patient.domain.usecases.cruds.PatientFindByIdUseCase;
import com.app.appointmentapp.patient.domain.usecases.cruds.PatientSaveUseCase;
import com.app.appointmentapp.patient.domain.usecases.filters.PatientFilterByNameUseCase;
import org.springframework.stereotype.Component;

@Component
public class PatientProviderImpl implements PatientProvider {
    private final PatientResheduleUseCase patientResheduleUseCase;
    private final PatientSaveUseCase patientSaveUseCase;
    private final AcceptReschedulingUseCase acceptReschedulingUseCase;
    private final PatientFindAllUseCase patientFindAllUseCase;
    private final PatientFindByIdUseCase patientFindByIdUseCase;
    private final PatientDeleteUseCase patientDeleteUseCase;
    private final CancelReschedulingUseCase cancelReschedulingUseCase;
    private final PatientFilterByNameUseCase patientFilterByNameUseCase;

    public PatientProviderImpl(PatientResheduleUseCase patientResheduleUseCase, PatientSaveUseCase patientSaveUseCase, AcceptReschedulingUseCase acceptReschedulingUseCase, PatientFindAllUseCase patientFindAllUseCase, PatientFindByIdUseCase patientFindByIdUseCase, PatientDeleteUseCase patientDeleteUseCase, CancelReschedulingUseCase cancelReschedulingUseCase, PatientFilterByNameUseCase patientFilterByNameUseCase) {
        this.patientResheduleUseCase = patientResheduleUseCase;
        this.patientSaveUseCase = patientSaveUseCase;
        this.acceptReschedulingUseCase = acceptReschedulingUseCase;
        this.patientFindAllUseCase = patientFindAllUseCase;
        this.patientFindByIdUseCase = patientFindByIdUseCase;
        this.patientDeleteUseCase = patientDeleteUseCase;
        this.cancelReschedulingUseCase = cancelReschedulingUseCase;
        this.patientFilterByNameUseCase = patientFilterByNameUseCase;
    }

    @Override
    public PatientResheduleUseCase getPatientResheduleUseCase() {
        return patientResheduleUseCase;
    }

    @Override
    public PatientSaveUseCase getPatientSaveUseCase() {
        return patientSaveUseCase;
    }

    @Override
    public AcceptReschedulingUseCase getAcceptReschedulingUseCase() {
        return acceptReschedulingUseCase;
    }

    @Override
    public PatientFindAllUseCase getPatientFindAllUseCase() {
        return patientFindAllUseCase;
    }

    @Override
    public PatientFindByIdUseCase getPatientFindByIdUseCase() {
        return patientFindByIdUseCase;
    }

    @Override
    public PatientDeleteUseCase getPatientDeleteUseCase() {
        return patientDeleteUseCase;
    }

    @Override
    public CancelReschedulingUseCase getCancelReschedulingUseCase() {
        return cancelReschedulingUseCase;
    }

    @Override
    public PatientFilterByNameUseCase getPatientFilterByNameUseCase() {
        return patientFilterByNameUseCase;
    }
}
