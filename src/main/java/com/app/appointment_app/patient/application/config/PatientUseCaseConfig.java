package com.app.appointment_app.patient.application.config;

import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentSaveGetway;
import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilitySaveGetway;
import com.app.appointment_app.patient.domain.getways.business_services.AcceptReschedulingGetway;
import com.app.appointment_app.patient.domain.getways.business_services.CancelReschedulingGetway;
import com.app.appointment_app.patient.domain.getways.business_services.PatientRescheduleGetway;
import com.app.appointment_app.patient.domain.getways.cruds.PatientDeleteGetway;
import com.app.appointment_app.patient.domain.getways.cruds.PatientFindAllGetway;
import com.app.appointment_app.patient.domain.getways.cruds.PatientFindByIdGetway;
import com.app.appointment_app.patient.domain.getways.cruds.PatientSaveGetway;
import com.app.appointment_app.patient.domain.getways.filters.PatientFilterByNameGetway;
import com.app.appointment_app.patient.domain.usecases.business_services.AcceptReschedulingUseCase;
import com.app.appointment_app.patient.domain.usecases.business_services.CancelReschedulingUseCase;
import com.app.appointment_app.patient.domain.usecases.business_services.PatientResheduleUseCase;
import com.app.appointment_app.patient.domain.usecases.cruds.PatientDeleteUseCase;
import com.app.appointment_app.patient.domain.usecases.cruds.PatientFindAllUseCase;
import com.app.appointment_app.patient.domain.usecases.cruds.PatientFindByIdUseCase;
import com.app.appointment_app.patient.domain.usecases.cruds.PatientSaveUseCase;
import com.app.appointment_app.patient.domain.usecases.filters.PatientFilterByNameUseCase;
import com.app.appointment_app.patient.domain.usecases.helpers.AcceptReschedulingHelper;
import com.app.appointment_app.patient.domain.usecases.helpers.CancelReschedulingHelper;
import com.app.appointment_app.patient.domain.usecases.helpers.PatientRescheduleHelper;
import com.app.appointment_app.pendinghour.domain.getways.factories.CreatePendingHourFactoryGetway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientUseCaseConfig {
    @Bean
    public PatientFilterByNameUseCase patientFilterByNameUseCase(PatientFilterByNameGetway patientFilterByNameGetway){
        return new PatientFilterByNameUseCase(patientFilterByNameGetway);
    }
    @Bean
    public PatientRescheduleHelper patientRescheduleHelperConfig(AppointmentSaveGetway appointmentSaveGetway
            , AppointmentFindByIdGetway appointmentFindByIdGetway, DisponibilitySaveGetway disponibilitySaveGetway
            , CreatePendingHourFactoryGetway createPendingHourFactoryGetway){
        return new PatientRescheduleHelper(appointmentSaveGetway, appointmentFindByIdGetway, disponibilitySaveGetway, createPendingHourFactoryGetway);
    }
    @Bean
    public PatientResheduleUseCase patientResheduleUseCaseConfig(PatientRescheduleGetway patientRescheduleGetway
            , PatientRescheduleHelper patientRescheduleHelper){
        return new PatientResheduleUseCase(patientRescheduleGetway, patientRescheduleHelper);
    }
    @Bean
    public CancelReschedulingHelper cancelReschedulingHelperConfig(
            AppointmentSaveGetway appointmentSaveGetway
            , AppointmentFindByIdGetway appointmentFindByIdGetway, DisponibilitySaveGetway
            disponibilitySaveGetway){
        return new CancelReschedulingHelper(appointmentSaveGetway
                , appointmentFindByIdGetway, disponibilitySaveGetway);
    }
    @Bean
    public CancelReschedulingUseCase cancelReschedulingUseCaseConfig(
            CancelReschedulingGetway cancelReschedulingGetway, CancelReschedulingHelper cancelReschedulingHelper){
        return new CancelReschedulingUseCase(cancelReschedulingGetway, cancelReschedulingHelper);
    }
    @Bean
    public AcceptReschedulingHelper acceptReschedulingHelperConfig(AppointmentSaveGetway appointmentSaveGetway
            , AppointmentFindByIdGetway appointmentFindByIdGetway){
        return new AcceptReschedulingHelper(appointmentSaveGetway, appointmentFindByIdGetway);
    }
    @Bean
    public AcceptReschedulingUseCase acceptReschedulingUseCaseConfig(AcceptReschedulingGetway acceptReschedulingGetway
            , AcceptReschedulingHelper acceptReschedulingHelper){
        return new AcceptReschedulingUseCase(acceptReschedulingGetway, acceptReschedulingHelper);
    }
    @Bean
    public PatientSaveUseCase patientSaveUseCaseConfig(PatientSaveGetway patientSaveGetway){
        return new PatientSaveUseCase(patientSaveGetway);
    }
    
    @Bean
    public PatientDeleteUseCase patientDeleteUseCaseConfig(PatientDeleteGetway patientDeleteGetway){
        return new PatientDeleteUseCase(patientDeleteGetway);
    }
    
    @Bean
    public PatientFindByIdUseCase patientFindByIdUseCaseConfig(PatientFindByIdGetway patientFindByIdGetway){
        return new PatientFindByIdUseCase(patientFindByIdGetway);
    }
    
    @Bean
    public PatientFindAllUseCase patientFindAllUseCaseConfig(PatientFindAllGetway patientFindAllGetway){
        return new PatientFindAllUseCase(patientFindAllGetway);
    }
}
