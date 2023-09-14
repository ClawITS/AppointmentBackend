package com.app.appointment_app.patient.domain.getways.cruds;

import com.app.appointment_app.patient.domain.model.Patient;
import org.springframework.data.domain.Page;

import java.util.List;


public interface PatientFindAllGetway {
     Page<Patient> findAllPaginator(int numberPage);
    List<Patient> findAll();
}
