package com.app.appointmentapp.doctor.domain.usecases.cruds;

import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.domain.model.enums.DisponibilityState;
import com.app.appointmentapp.doctor.domain.dto.mappers.DoctorResponseMapper;
import com.app.appointmentapp.doctor.domain.dto.response.DoctorResponse;
import com.app.appointmentapp.doctor.domain.exceptions.DoctorException;
import com.app.appointmentapp.doctor.domain.getways.cruds.DoctorSaveGetway;
import com.app.appointmentapp.doctor.domain.model.Doctor;
import com.app.appointmentapp.doctor.domain.usecases.helpers.DoctorSaveHelper;

import java.util.List;

public class DoctorSaveUseCase {
    private final DoctorSaveGetway doctorSaveGetway;
    private final DoctorSaveHelper doctorSaveHelper;
    private final DoctorResponseMapper doctorResponseMapper;

    public DoctorSaveUseCase(DoctorSaveGetway doctorSaveGetway, DoctorSaveHelper doctorSaveHelper, DoctorResponseMapper doctorResponseMapper) {
        this.doctorSaveGetway = doctorSaveGetway;
        this.doctorSaveHelper = doctorSaveHelper;
        this.doctorResponseMapper = doctorResponseMapper;
    }

    public DoctorResponse saveDoctor(Doctor doctor) {
        try {
            doctorSaveHelper.chargeDoctorWithSpeciality(doctor);
        }catch (DoctorException e){
            return new DoctorResponse.DoctorResponseBuilder()
                    .withDescription(e.getMessage()).build();
        }
        if (!doctor.getDisponibilityList().isEmpty()) {
            Doctor doctor1 = setDisponibilityList(doctor);
            return doctorResponseMapper.toDoctorResponse(doctorSaveGetway.saveDoctor(doctor1));
        }
        return doctorResponseMapper.toDoctorResponse(doctorSaveGetway.saveDoctor(doctor));
    }
    private Doctor setDisponibilityList(Doctor doctor) {
        List<Disponibility> listDisponibilities = doctor.getDisponibilityList();
        Doctor doctor1 = saveDoctorWithoutList(doctor);
        setListDisponibilitiesWithDoctorSavedAndDoctorWithDisponibilityList(listDisponibilities, doctor1);
        return doctor1;
    }

    private void setListDisponibilitiesWithDoctorSavedAndDoctorWithDisponibilityList(List<Disponibility> listDisponibilities, Doctor doctor1) {
        listDisponibilities.forEach(disponibility ->{
                    disponibility.setDoctor(doctor1);
                    disponibility.setDisponibilityState(DisponibilityState.AVAILABLE);
                });
        doctor1.setDisponibilityList(listDisponibilities);
    }

    private Doctor saveDoctorWithoutList(Doctor doctor) {
        doctor.setDisponibilityList(null);
        Doctor doctor1 =doctorSaveGetway.saveDoctor(doctor);
        return doctor1;
    }
}
