package com.app.appointmentapp.doctor.domain.usecases.cruds;

import com.app.appointmentapp.doctor.domain.getways.cruds.DoctorFindAllGetway;
import com.app.appointmentapp.doctor.domain.model.Doctor;
import org.springframework.data.domain.Page;
public class DoctorFindAllUseCase {

    private final DoctorFindAllGetway doctorFindAllGetway;

    public DoctorFindAllUseCase(DoctorFindAllGetway doctorFindAllGetway) {
        this.doctorFindAllGetway = doctorFindAllGetway;
    }
    public Page<Doctor> findAllDoctorsPaginator(int numberPage){
        return doctorFindAllGetway.findAllPaginator(numberPage);
    }
}
