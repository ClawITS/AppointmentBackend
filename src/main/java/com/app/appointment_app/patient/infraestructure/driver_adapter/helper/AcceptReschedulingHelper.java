package com.app.appointment_app.patient.infraestructure.driver_adapter.helper;

import com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository.AppointmentData;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.s3_repository.AppointmentRepository;
import com.app.appointment_app.patient.domain.constants.PatientResponseMessages;
import com.app.appointment_app.patient.domain.requests.AcceptReschedulingRequest;
import com.app.appointment_app.patient.domain.responses.AcceptReschedulingResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AcceptReschedulingHelper {
    private final AppointmentRepository appointmentRepository;

    public AcceptReschedulingHelper(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AcceptReschedulingResponse acceptRescheduling(AcceptReschedulingRequest acceptReschedulingRequest){
       Optional<AppointmentData> appointmentData = appointmentRepository.findById(acceptReschedulingRequest.getIdAppointment());
       appointmentData.get().setState(acceptReschedulingRequest.getState());
       appointmentRepository.save(appointmentData.get());
       return new AcceptReschedulingResponse(PatientResponseMessages.PATIENT_ACCEPT_RESCHEDULING +
               appointmentData.get().getPatientData().getName());
    }
}
