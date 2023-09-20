package com.app.appointmentapp.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.getway;

import com.app.appointmentapp.pendinghour.domain.getways.factories.CreatePendingHourFactoryGetway;
import com.app.appointmentapp.pendinghour.domain.getways.factories.PendingHourTypeToCreate;
import com.app.appointmentapp.pendinghour.domain.model.PendingHourDoctor;
import com.app.appointmentapp.pendinghour.domain.model.PendingHourPatient;
import com.app.appointmentapp.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.entity.PendingHourDoctorData;
import com.app.appointmentapp.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.entity.PendingHourPatientData;
import com.app.appointmentapp.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.mapper.PendingDoctorHourMapper;
import com.app.appointmentapp.pendinghour.infraestructure.driver_adapter.s3_repository.PendingDoctorHourRepository;
import com.app.appointmentapp.pendinghour.infraestructure.driver_adapter.s3_repository.PendingPatientHourRepository;
import com.app.appointmentapp.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.mapper.PendingPatientHourMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.app.appointmentapp.pendinghour.domain.getways.factories.PendingHourTypeToCreate.PENDINGHOURDOCTOR;
import static com.app.appointmentapp.pendinghour.domain.getways.factories.PendingHourTypeToCreate.PENDINGHOURPATIENT;

@Repository
public class PendingHourGetwayImpl implements CreatePendingHourFactoryGetway {

    @Autowired
    private PendingPatientHourRepository pendingPatientHourRepository;
    @Autowired
    private PendingPatientHourMapper pendingPatientHourMapper;
    @Autowired
    private PendingDoctorHourMapper pendingDoctorHourMapper;
    @Autowired
    private PendingDoctorHourRepository pendingDoctorHourRepository;


    @Override
    public Optional<?> createPendingHour(Object object, PendingHourTypeToCreate type) {

        if(type.equals(PENDINGHOURPATIENT)){
            PendingHourPatientData pendingData=pendingPatientHourMapper.toPendingData((PendingHourPatient) object);
            return Optional.of(pendingPatientHourRepository.save(pendingData));
        } else if (type.equals(PENDINGHOURDOCTOR)) {
            PendingHourDoctorData pendingData = pendingDoctorHourMapper.toPendingData((PendingHourDoctor) object);
            return Optional.of(pendingDoctorHourRepository.save(pendingData));
        }
        return Optional.empty();
    }
}
