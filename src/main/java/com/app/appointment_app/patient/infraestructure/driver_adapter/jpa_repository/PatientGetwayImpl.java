package com.app.appointment_app.patient.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.patient.domain.getways.*;
import com.app.appointment_app.patient.domain.model.Patient;
import com.app.appointment_app.patient.infraestructure.driver_adapter.s3_repository.PatientRepository;
import com.app.appointment_app.patient.infraestructure.mapper.PatientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PatientGetwayImpl implements PatientDeleteGetway, PatientFindByIdGetway, PatientSaveGetway, PatientFindAllGetway {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Page<Patient> findAllPaginator(int numberPage) {
        int pageSize = 12;
        PageRequest page = PageRequest.of(numberPage, pageSize);
        Page<PatientData> data = patientRepository.findAll(page);
        return data.map(patientMapper::toPatient);
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll().stream()
                .map(patientMapper::toPatient)
                .collect(Collectors.toList());
    }

    @Override
    public Patient findById(Long id) {
        Optional<PatientData> data = patientRepository.findById(id);
        return patientMapper.toPatient(data.get());
    }

    @Override
    public Patient save(Patient patient) {
        return patientMapper.toPatient(patientRepository.save(patientMapper.toData(patient)));
    }
}