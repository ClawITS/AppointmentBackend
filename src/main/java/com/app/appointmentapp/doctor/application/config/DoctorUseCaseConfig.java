package com.app.appointmentapp.doctor.application.config;
import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentFindByIdGetway;
import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentUpdateStateGetway;
import com.app.appointmentapp.doctor.domain.dto.mappers.DoctorResponseMapper;
import com.app.appointmentapp.doctor.domain.getways.business_services.AcceptPatientReschedulingGetway;
import com.app.appointmentapp.doctor.domain.getways.business_services.RescheduleAppointmentGetway;
import com.app.appointmentapp.doctor.domain.getways.cruds.DoctorDeleteGetway;
import com.app.appointmentapp.doctor.domain.getways.cruds.DoctorFindAllGetway;
import com.app.appointmentapp.doctor.domain.getways.cruds.DoctorFindByIdGetway;
import com.app.appointmentapp.doctor.domain.getways.cruds.DoctorSaveGetway;
import com.app.appointmentapp.doctor.domain.useCases.business_services.AcceptPatientReschedulingUseCase;
import com.app.appointmentapp.doctor.domain.useCases.business_services.RescheduleAppointmentUseCase;
import com.app.appointmentapp.doctor.domain.useCases.cruds.DoctorDeleteUseCase;
import com.app.appointmentapp.doctor.domain.useCases.cruds.DoctorFindAllUseCase;
import com.app.appointmentapp.doctor.domain.useCases.cruds.DoctorFindByIdUseCase;
import com.app.appointmentapp.doctor.domain.useCases.cruds.DoctorSaveUseCase;
import com.app.appointmentapp.doctor.domain.useCases.helpers.AcceptPatientReschedulingHelper;
import com.app.appointmentapp.doctor.domain.useCases.helpers.RescheduleAppointmentHelper;
import com.app.appointmentapp.pendinghour.domain.getways.factories.CreatePendingHourFactoryGetway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoctorUseCaseConfig {
    @Bean
    public DoctorResponseMapper doctorResponseMapperConfig(){
        return new DoctorResponseMapper();
    }
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
    public DoctorSaveUseCase doctorSaveUseCaseConfig(DoctorSaveGetway doctorSaveGetway,
                                                     DoctorResponseMapper doctorResponseMapper){
        return new DoctorSaveUseCase(doctorSaveGetway, doctorResponseMapper);
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
            ){
        return new AcceptPatientReschedulingHelper(appointmentFindByIdGetway);
    }
    @Bean
    public AcceptPatientReschedulingUseCase acceptPatientReschedulingUseCaseConfig(AcceptPatientReschedulingGetway acceptPatientReschedulingGetway
            , AcceptPatientReschedulingHelper acceptPatientReschedulingHelper){
        return  new AcceptPatientReschedulingUseCase(acceptPatientReschedulingGetway, acceptPatientReschedulingHelper);

    }

}
