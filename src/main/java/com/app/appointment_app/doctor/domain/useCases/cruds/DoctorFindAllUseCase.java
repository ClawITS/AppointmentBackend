package com.app.appointment_app.doctor.domain.useCases.cruds;

import com.app.appointment_app.doctor.domain.getways.cruds.DoctorFindAllGetway;
import com.app.appointment_app.doctor.domain.model.Doctor;
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
