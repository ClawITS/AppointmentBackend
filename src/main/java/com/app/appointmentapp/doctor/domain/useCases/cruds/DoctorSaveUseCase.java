package com.app.appointmentapp.doctor.domain.useCases.cruds;

import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.domain.model.enums.DisponibilityState;
import com.app.appointmentapp.doctor.domain.dto.mappers.DoctorResponseMapper;
import com.app.appointmentapp.doctor.domain.dto.response.DoctorResponse;
import com.app.appointmentapp.doctor.domain.getways.cruds.DoctorSaveGetway;
import com.app.appointmentapp.doctor.domain.model.Doctor;

import java.util.List;

public class DoctorSaveUseCase {
    private final DoctorSaveGetway doctorSaveGetway;
    private final DoctorResponseMapper doctorResponseMapper;

    public DoctorSaveUseCase(DoctorSaveGetway doctorSaveGetway, DoctorResponseMapper doctorResponseMapper) {
        this.doctorSaveGetway = doctorSaveGetway;
        this.doctorResponseMapper = doctorResponseMapper;
    }

    public DoctorResponse saveDoctor(Doctor doctor) {
        if (!doctor.getDisponibilityList().isEmpty()) {
            List<Disponibility> listDisponibilities = doctor.getDisponibilityList();
            Doctor doctor1 = saveDoctorWithoutList(doctor);
            setListDisponibilitiesWithDoctorSavedAndDoctorWithDisponibilityList(listDisponibilities, doctor1);

            return doctorResponseMapper.toDoctorResponse(doctorSaveGetway.saveDoctor(doctor1));
        }
        return doctorResponseMapper
                .toDoctorResponse(doctorSaveGetway.saveDoctor(doctor));
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
