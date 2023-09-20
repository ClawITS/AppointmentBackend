package com.app.appointmentapp.disponibility.domain.usecases.helpers;

import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.domain.requests.DisponibilitySaveRequest;
import com.app.appointmentapp.doctor.domain.getways.cruds.DoctorFindByIdGetway;
import com.app.appointmentapp.doctor.domain.model.Doctor;

public class DisponibilitySaveHelper {
    private final DoctorFindByIdGetway doctorFindByIdGetway;


    public DisponibilitySaveHelper(DoctorFindByIdGetway doctorFindByIdGetway) {
        this.doctorFindByIdGetway = doctorFindByIdGetway;
    }

    public Disponibility addDoctorToDisponibility(DisponibilitySaveRequest disponibilitySaveRequest){
       Doctor doctor = doctorFindByIdGetway.findById(disponibilitySaveRequest.getIdDoctor());
       return new Disponibility(null,disponibilitySaveRequest.getHour(),doctor, null);
    }
}
