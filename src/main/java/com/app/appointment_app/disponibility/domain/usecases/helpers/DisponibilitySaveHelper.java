package com.app.appointment_app.disponibility.domain.usecases.helpers;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.requests.DisponibilitySaveRequest;
import com.app.appointment_app.doctor.domain.getways.DoctorFindByIdGetway;
import com.app.appointment_app.doctor.domain.model.Doctor;

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
