package com.app.appointment_app.speciality.domain.usecases.cruds;

import com.app.appointment_app.speciality.domain.getways.cruds.SpecialityFindAllGetway;
import com.app.appointment_app.speciality.domain.model.Speciality;
import org.springframework.data.domain.Page;

import java.util.List;

public class SpecialityFindAllUseCase {
    private final SpecialityFindAllGetway specialityFindAllGetway;

    public SpecialityFindAllUseCase(SpecialityFindAllGetway specialityFindAllGetway) {
        this.specialityFindAllGetway = specialityFindAllGetway;
    }
    public Page<Speciality> findAllSpecialityPaginator(int numberPage){
        return specialityFindAllGetway.findAllPaginator(numberPage);
    }
    public List<Speciality> findAll(){
        return specialityFindAllGetway.findAll();
    }
}
