package com.app.appointment_app.appointment.infraestructure.driver_adapter.helper;

import com.app.appointment_app.appointment.domain.constants.CloseAppointmentMessages;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.appointment.domain.requests.CloseAppointmentRequest;
import com.app.appointment_app.appointment.domain.responses.CloseAppointmentResponse;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository.AppointmentData;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.s3_repository.AppointmentRepository;
import com.app.appointment_app.disponibility.domain.model.enums.DisponibilityState;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CloseAppointmentHelper {
    private final AppointmentRepository appointmentRepository;

    public CloseAppointmentHelper(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public CloseAppointmentResponse attendAppointment(CloseAppointmentRequest closeAppointmentRequest){
      Optional<AppointmentData> appointmentData = appointmentRepository
              .findById(closeAppointmentRequest.getIdAppointment());
       ifAppointmentAttendedCloseDisponibility(closeAppointmentRequest.getState(), appointmentData);
       appointmentRepository.save(appointmentData.get());
       return new CloseAppointmentResponse(appointmentData
               .get().getDisponibility().getHour(), CloseAppointmentMessages.ATTEND_APPOINTMENT
               + LocalDateTime.now().toString()
               );
    }
    private void ifAppointmentAttendedCloseDisponibility(State state, Optional<AppointmentData> appointmentData) {
        if(state.equals(State.ATTENDED)){
            appointmentData.get().getDisponibility().setDisponibilityState(DisponibilityState.CLOSED);
        }
    }


}
