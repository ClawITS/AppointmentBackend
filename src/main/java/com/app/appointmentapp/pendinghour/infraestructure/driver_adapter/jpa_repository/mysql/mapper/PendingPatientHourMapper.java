package com.app.appointmentapp.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.mapper;

import com.app.appointmentapp.pendinghour.domain.model.PendingHourPatient;
import com.app.appointmentapp.pendinghour.infraestructure.driver_adapter.jpa_repository.mysql.entity.PendingHourPatientData;
import org.springframework.stereotype.Component;

@Component
public class PendingPatientHourMapper {

    public PendingHourPatientData toPendingData (PendingHourPatient pendingHourPatient){
        return new PendingHourPatientData(pendingHourPatient.getNewHour()
                , pendingHourPatient.getIdPatientPendingHour());
    }
    public PendingHourPatient toPending (PendingHourPatientData pendingHourPatientData){
        return new PendingHourPatient(pendingHourPatientData.getNewHour()
                , pendingHourPatientData.getIdPatientPendingHour());
    }

}
