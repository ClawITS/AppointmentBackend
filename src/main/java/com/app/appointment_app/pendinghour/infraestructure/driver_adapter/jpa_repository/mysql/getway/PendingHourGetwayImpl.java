package com.app.appointment_app.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.getway;

import com.app.appointment_app.pendinghour.domain.getways.factories.CreatePendingHourFactoryGetway;
import com.app.appointment_app.pendinghour.domain.getways.factories.PendingHourTypeToCreate;
import com.app.appointment_app.pendinghour.domain.model.PendingHourDoctor;
import com.app.appointment_app.pendinghour.domain.model.PendingHourPatient;
import com.app.appointment_app.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.entity.PendingHourDoctorData;
import com.app.appointment_app.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.entity.PendingHourPatientData;
import com.app.appointment_app.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.mapper.PendingDoctorHourMapper;
import com.app.appointment_app.pendinghour.infraestructure.driver_adapter.s3_repository.PendingDoctorHourRepository;
import com.app.appointment_app.pendinghour.infraestructure.driver_adapter.s3_repository.PendingPatientHourRepository;
import com.app.appointment_app.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.mapper.PendingPatientHourMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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

        if(type.equals(type.PENDINGHOURPATIENT)){
            PendingHourPatientData pendingData=pendingPatientHourMapper.toPendingData((PendingHourPatient) object);
            return Optional.of(pendingPatientHourRepository.save(pendingData));
        } else if (type.equals(type.PENDINGHOURDOCTOR)) {
            PendingHourDoctorData pendingData = pendingDoctorHourMapper.toPendingData((PendingHourDoctor) object);
            return Optional.of(pendingDoctorHourRepository.save(pendingData));
        }
        return Optional.empty();
    }
}
