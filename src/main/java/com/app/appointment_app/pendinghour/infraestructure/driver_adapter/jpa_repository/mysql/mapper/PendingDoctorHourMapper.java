package com.app.appointment_app.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.mapper;
import com.app.appointment_app.pendinghour.domain.model.PendingHourDoctor;
import com.app.appointment_app.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.entity.PendingHourDoctorData;
import org.springframework.stereotype.Component;

@Component
public class PendingDoctorHourMapper {

    public PendingHourDoctorData toPendingData (PendingHourDoctor pendingHourDoctor){
        return new PendingHourDoctorData(pendingHourDoctor.getNewHour()
                , pendingHourDoctor.getIdDoctorPendingHour());
    }
    public PendingHourDoctor toPending (PendingHourDoctorData pendingHourDoctorData){
        return new PendingHourDoctor(pendingHourDoctorData.getNewHour()
                , pendingHourDoctorData.getIdDoctorPendingHour());
    }

}
