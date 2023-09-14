package com.app.appointment_app.doctor.application.config;
import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentSaveGetway;
import com.app.appointment_app.appointment.domain.getways.cruds.AppointmentUpdateStateGetway;
import com.app.appointment_app.disponibility.domain.getways.cruds.DisponibilitySaveGetway;
import com.app.appointment_app.doctor.domain.getways.business_services.AcceptPatientReschedulingGetway;
import com.app.appointment_app.doctor.domain.getways.business_services.RescheduleAppointmentGetway;
import com.app.appointment_app.doctor.domain.getways.cruds.DoctorDeleteGetway;
import com.app.appointment_app.doctor.domain.getways.cruds.DoctorFindAllGetway;
import com.app.appointment_app.doctor.domain.getways.cruds.DoctorFindByIdGetway;
import com.app.appointment_app.doctor.domain.getways.cruds.DoctorSaveGetway;
import com.app.appointment_app.doctor.domain.useCases.business_services.AcceptPatientReschedulingUseCase;
import com.app.appointment_app.doctor.domain.useCases.business_services.RescheduleAppointmentUseCase;
import com.app.appointment_app.doctor.domain.useCases.cruds.DoctorDeleteUseCase;
import com.app.appointment_app.doctor.domain.useCases.cruds.DoctorFindAllUseCase;
import com.app.appointment_app.doctor.domain.useCases.cruds.DoctorFindByIdUseCase;
import com.app.appointment_app.doctor.domain.useCases.cruds.DoctorSaveUseCase;
import com.app.appointment_app.doctor.domain.useCases.helpers.AcceptPatientReschedulingHelper;
import com.app.appointment_app.doctor.domain.useCases.helpers.RescheduleAppointmentHelper;
import com.app.appointment_app.pendinghour.domain.getways.factories.CreatePendingHourFactoryGetway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoctorUseCaseConfig {
    @Bean
    public RescheduleAppointmentHelper rescheduleAppointmentHelperConfig(
             CreatePendingHourFactoryGetway createPendingHourFactoryGetway
            , AppointmentUpdateStateGetway appointmentUpdateStateGetway){
        return new RescheduleAppointmentHelper(createPendingHourFactoryGetway, appointmentUpdateStateGetway);
    }
    @Bean
    public RescheduleAppointmentUseCase rescheduleAppointmentUseCaseConfig(RescheduleAppointmentGetway rescheduleAppointmentGetyaw
            , RescheduleAppointmentHelper rescheduleAppointmentHelper){
        return new RescheduleAppointmentUseCase(rescheduleAppointmentGetyaw, rescheduleAppointmentHelper);
    }


    @Bean
    public DoctorSaveUseCase doctorSaveUseCaseConfig(DoctorSaveGetway doctorSaveGetway){
        return new DoctorSaveUseCase(doctorSaveGetway);
    }
    @Bean
    public DoctorDeleteUseCase doctorDeleteUseCaseConfig(DoctorDeleteGetway doctorDeleteGetway){
        return new DoctorDeleteUseCase(doctorDeleteGetway);
    }
    @Bean
    public DoctorFindByIdUseCase doctorFindByIdUseCase(DoctorFindByIdGetway doctorFindByIdGetway){
        return new DoctorFindByIdUseCase(doctorFindByIdGetway);
    }
    @Bean
    public DoctorFindAllUseCase doctorFindAllUseCaseConfig(DoctorFindAllGetway doctorFindAllGetway){
        return new DoctorFindAllUseCase(doctorFindAllGetway);
    }
    @Bean
    public AcceptPatientReschedulingHelper acceptPatientReschedulingHelper(AppointmentFindByIdGetway appointmentFindByIdGetway
            , AppointmentSaveGetway appointmentSaveGetway, DisponibilitySaveGetway disponibilitySaveGetway){
        return new AcceptPatientReschedulingHelper(appointmentFindByIdGetway, appointmentSaveGetway, disponibilitySaveGetway);
    }
    @Bean
    public AcceptPatientReschedulingUseCase acceptPatientReschedulingUseCaseConfig(AcceptPatientReschedulingGetway acceptPatientReschedulingGetway
            , AcceptPatientReschedulingHelper acceptPatientReschedulingHelper){
        return  new AcceptPatientReschedulingUseCase(acceptPatientReschedulingGetway, acceptPatientReschedulingHelper);

    }

}
