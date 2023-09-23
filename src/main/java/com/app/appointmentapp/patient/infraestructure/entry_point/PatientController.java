package com.app.appointmentapp.patient.infraestructure.entry_point;

import com.app.appointmentapp.appointment.domain.exceptions.AppointmentException;
import com.app.appointmentapp.appointment.domain.exceptions.CancelReschedulingException;
import com.app.appointmentapp.commons.infraestructure.rest.dto.response.CustomResponse;
import com.app.appointmentapp.commons.infraestructure.rest.entry_points.controller.GenericRestController;
import com.app.appointmentapp.patient.domain.exceptions.PatientException;
import com.app.appointmentapp.patient.domain.model.Patient;
import com.app.appointmentapp.patient.domain.requests.AcceptReschedulingRequest;
import com.app.appointmentapp.patient.domain.requests.CancelReschedulingRequest;
import com.app.appointmentapp.patient.domain.requests.PatientFilterByNameRequest;
import com.app.appointmentapp.patient.domain.requests.PatientRescheduleRequest;
import com.app.appointmentapp.patient.domain.responses.AcceptReschedulingResponse;
import com.app.appointmentapp.patient.domain.responses.CancelReschedulingResponse;
import com.app.appointmentapp.patient.domain.responses.PatientRescheduleResponse;
import com.app.appointmentapp.patient.infraestructure.entry_point.provider.PatientProvider;
import com.app.appointmentapp.patient.infraestructure.entry_point.validate.ValidatePatient;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.appointmentapp.doctor.infraestructure.entry_point.constants.DoctorApiConstants.REQUEST_DOCTOR;
import static com.app.appointmentapp.patient.domain.constants.PatientResponseConstants.PATIENT_ACCEPT_RESCHEDULING;
import static com.app.appointmentapp.patient.infraestructure.entry_point.constants.PatientApiConstants.REQUEST_PATIENT;
import static com.app.appointmentapp.patient.infraestructure.entry_point.constants.PatientResponseConstants.PATIENT_SAVED;

@RestController
@RequestMapping("/api/patients")
public class PatientController extends GenericRestController implements IPatientController {

    private final PatientProvider patientProvider;

    public PatientController(PatientProvider patientProvider) {
        this.patientProvider = patientProvider;
    }

    @Override
    public ResponseEntity<CustomResponse> findById(@PathVariable Long id) {
        try{
            return ok(patientProvider
                            .getPatientFindByIdUseCase().findPatientById(id), "patient finded",
                    REQUEST_PATIENT);
        }catch (PatientException e){
            return bad(null, e.getMessage(),REQUEST_PATIENT);
        }
    }

    @Override
    public ResponseEntity<CustomResponse> save(@RequestBody Patient patient, BindingResult bindingResult) {
        ValidatePatient.validatePatientRows(patient,bindingResult);
        if(bindingResult.hasErrors()){
            return bad(patient,bindingResult.getFieldError().getDefaultMessage(), REQUEST_DOCTOR);
        }
        return create(patientProvider
                .getPatientSaveUseCase().savePatient(patient),
                PATIENT_SAVED, REQUEST_PATIENT);
    }
    @Override
    public ResponseEntity<CustomResponse> acceptRescheduling(@RequestBody AcceptReschedulingRequest acceptReschedulingRequest,
                                                                         BindingResult bindingResult){
     ValidatePatient.validatePatientAcceptRechedule(acceptReschedulingRequest,bindingResult);
     if(bindingResult.hasErrors()){
         return bad(acceptReschedulingRequest,bindingResult.getFieldError().getDefaultMessage(), REQUEST_DOCTOR);

     }
        return ok(patientProvider
                .getAcceptReschedulingUseCase().acceptRescheduling(acceptReschedulingRequest),
                PATIENT_ACCEPT_RESCHEDULING, REQUEST_PATIENT);
    }

    @Override
    public ResponseEntity<Page<Patient>> getPatientPage(@PathVariable int numberPage) {
        return new ResponseEntity<>(patientProvider
                .getPatientFindAllUseCase().findAllPatientPaginator(numberPage), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deletePatientById(@PathVariable Long id) {
        patientProvider.getPatientDeleteUseCase().deletePatientById(id);
        return new ResponseEntity<>("the entity with id " + id + " has been deleted", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CancelReschedulingResponse> cancelRescheduling(@RequestBody CancelReschedulingRequest cancelReschedulingRequest){
        try{
            CancelReschedulingException.cancelReschedulingException(cancelReschedulingRequest);
            return new ResponseEntity<>(patientProvider
                    .getCancelReschedulingUseCase().cancelRescheduling(cancelReschedulingRequest), HttpStatus.OK);
        }catch(AppointmentException e){
            return ResponseEntity.badRequest().body(new CancelReschedulingResponse(e.getMessage()));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CancelReschedulingResponse(e.getMessage()));
        }

    }
    @Override
        public  ResponseEntity <PatientRescheduleResponse> patientReshedule(@RequestBody PatientRescheduleRequest patientRescheduleRequest){
            return new ResponseEntity<>(patientProvider
                    .getPatientResheduleUseCase().patientReschedule(patientRescheduleRequest),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Patient>> patientsFilteredByName(@RequestBody PatientFilterByNameRequest patientFilterByNameRequest) {
        return new ResponseEntity<>(patientProvider.getPatientFilterByNameUseCase()
                .filterPatientsByName(patientFilterByNameRequest), HttpStatus.OK);
    }
}
