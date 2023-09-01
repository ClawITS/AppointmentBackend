package com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository.helpers;

import com.app.appointment_app.appointment.infraestructure.driver_adapter.jpa_repository.AppointmentData;
import com.app.appointment_app.appointment.infraestructure.driver_adapter.s3_repository.AppointmentRepository;
import com.app.appointment_app.doctor.domain.constants.DoctorResponseMessages;
import com.app.appointment_app.doctor.domain.requests.RescheduleAppointmentRequest;
import com.app.appointment_app.doctor.domain.responses.RescheduleAppointmentResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RescheduleAppointmentHelper {

    private final AppointmentRepository appointmentRepository;

    public RescheduleAppointmentHelper(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public RescheduleAppointmentResponse rescheduleAppointment(RescheduleAppointmentRequest rescheduleAppointmentRequest){
        return updateAppointmentDisponibilityWithNewHour(rescheduleAppointmentRequest);

    }

    private RescheduleAppointmentResponse updateAppointmentDisponibilityWithNewHour(RescheduleAppointmentRequest rescheduleAppointmentRequest) {
        Optional<AppointmentData> appointmentData = appointmentRepository.findById(rescheduleAppointmentRequest.getIdAppointment());
        appointmentData.get().getDisponibility().setHour(rescheduleAppointmentRequest.getReschuldeHour());
        appointmentRepository.save(appointmentData.get());
        return new RescheduleAppointmentResponse(rescheduleAppointmentRequest.getReschuldeHour(),rescheduleAppointmentRequest
                .getActualHour(), DoctorResponseMessages.RESCHEDULE_APPOINTMENT +
                appointmentData.get().getPatientData().getName());
    }
}
