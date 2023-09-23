package com.app.appointmentapp.patient.domain.usecases.filters;

import com.app.appointmentapp.patient.domain.getways.filters.PatientFilterByNameGetway;
import com.app.appointmentapp.patient.domain.model.Patient;
import com.app.appointmentapp.patient.domain.requests.PatientFilterByNameRequest;

import java.util.Collections;
import java.util.List;

public class PatientFilterByNameUseCase {
    private final PatientFilterByNameGetway patientFilterByNameGetway;
    private static final int PAGE_SIZE = 10;

    public PatientFilterByNameUseCase(PatientFilterByNameGetway patientFilterByNameGetway) {
        this.patientFilterByNameGetway = patientFilterByNameGetway;
    }
    public List<Patient> filterPatientsByName(PatientFilterByNameRequest patientFilterByNameRequest){
        List<Patient> patients = patientFilterByNameGetway.getPatientsByName(patientFilterByNameRequest.getName());
        return getPage(patients, PAGE_SIZE, patientFilterByNameRequest.getNumberPage());
    }

    public List<Patient> getPage(List<Patient> list, int pageSize, int pageNumber) {
        int startIndex = pageNumber * pageSize;
        int endIndex = Math.min(startIndex + pageSize, list.size());
        if (startIndex >= endIndex || startIndex < 0) {
            return Collections.emptyList();
        }
        return list.subList(startIndex, endIndex);
    }
}