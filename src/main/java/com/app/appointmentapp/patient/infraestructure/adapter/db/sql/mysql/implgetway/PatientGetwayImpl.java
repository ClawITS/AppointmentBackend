package com.app.appointmentapp.patient.infraestructure.adapter.db.sql.mysql.implgetway;

import com.app.appointmentapp.appointment.domain.getways.cruds.AppointmentSaveGetway;
import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.patient.domain.constants.PatientResponseConstants;
import com.app.appointmentapp.patient.domain.getways.business_services.AcceptReschedulingGetway;
import com.app.appointmentapp.patient.domain.getways.business_services.CancelReschedulingGetway;
import com.app.appointmentapp.patient.domain.getways.business_services.PatientRescheduleGetway;
import com.app.appointmentapp.patient.domain.getways.cruds.PatientDeleteGetway;
import com.app.appointmentapp.patient.domain.getways.cruds.PatientFindAllGetway;
import com.app.appointmentapp.patient.domain.getways.cruds.PatientFindByIdGetway;
import com.app.appointmentapp.patient.domain.getways.cruds.PatientSaveGetway;
import com.app.appointmentapp.patient.domain.getways.filters.PatientFilterByNameGetway;
import com.app.appointmentapp.patient.domain.model.Patient;
import com.app.appointmentapp.patient.domain.requests.AcceptReschedulingRequest;
import com.app.appointmentapp.patient.domain.requests.CancelReschedulingRequest;
import com.app.appointmentapp.patient.domain.responses.AcceptReschedulingResponse;
import com.app.appointmentapp.patient.domain.responses.CancelReschedulingResponse;
import com.app.appointmentapp.patient.domain.responses.PatientRescheduleResponse;
import com.app.appointmentapp.patient.infraestructure.adapter.db.sql.mysql.entity.PatientData;
import com.app.appointmentapp.patient.infraestructure.adapter.db.sql.mysql.jpa_repository.PatientRepository;
import com.app.appointmentapp.patient.infraestructure.adapter.db.sql.mysql.mapper.PatientMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientGetwayImpl implements PatientDeleteGetway, PatientFindByIdGetway, PatientSaveGetway, PatientFindAllGetway,
        AcceptReschedulingGetway, CancelReschedulingGetway, PatientRescheduleGetway, PatientFilterByNameGetway {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    public PatientGetwayImpl(PatientRepository patientRepository, PatientMapper patientMapper, AppointmentSaveGetway appointmentSaveGetway) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

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
                .toList();
    }

    @Override
    public Patient findById(Long id) {
        Optional<PatientData> data = patientRepository.findById(id);
        if(data.isPresent()){
            return patientMapper.toPatient(data.get());
        }
        else{
            return null;
        }

    }

    @Override
    public Patient save(Patient patient) {
        return patientMapper.toPatient(patientRepository.save(patientMapper.toData(patient)));
    }

    @Override
    public AcceptReschedulingResponse acceptRescheduling(AcceptReschedulingRequest acceptReschedulingRequest) {
        return new AcceptReschedulingResponse(PatientResponseConstants.PATIENT_ACCEPT_RESCHEDULING);
    }

    @Override
    public CancelReschedulingResponse cancelRescheduling(CancelReschedulingRequest cancelReschedulingRequest) {
        return new CancelReschedulingResponse(PatientResponseConstants.PATIENT_CANCEL_RESCHEDULING);
    }

    @Override
    public PatientRescheduleResponse patientRescheduleGetway(Appointment appointment) {

        return new PatientRescheduleResponse(PatientResponseConstants.PATIENT_RESCHEDULING +
                appointment.getDisponibility().getDoctor().getName());
    }

    @Override
    public List<Patient> getPatientsByName(String name) {
        return patientRepository.findByNameContaining(name)
                .stream().map(patientMapper::toPatient)
                .toList();
    }
}
