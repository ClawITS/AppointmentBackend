package com.app.appointmentapp.appointment.domain.usecases.helpers;

import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.disponibility.domain.getways.cruds.DisponibilityFindByIdGetway;
import com.app.appointmentapp.disponibility.domain.getways.cruds.DisponibilitySaveGetway;
import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.domain.model.enums.DisponibilityState;
import com.app.appointmentapp.patient.domain.getways.cruds.PatientFindByIdGetway;
import com.app.appointmentapp.patient.domain.model.Patient;

public class AppointmentSaveHelper {
    private final DisponibilityFindByIdGetway disponibilityFindByIdGetway;
    private final DisponibilitySaveGetway disponibilitySaveGetway;
    private final PatientFindByIdGetway patientFindByIdGetway;

    public AppointmentSaveHelper(DisponibilityFindByIdGetway disponibilityFindByIdGetway,
                                 DisponibilitySaveGetway disponibilitySaveGetway
            , PatientFindByIdGetway patientFindByIdGetway) {
        this.disponibilityFindByIdGetway = disponibilityFindByIdGetway;
        this.disponibilitySaveGetway = disponibilitySaveGetway;
        this.patientFindByIdGetway = patientFindByIdGetway;
    }
    public void chargeDisponibilityToAppointment(Appointment appointment){
        Disponibility disponibility = disponibilityFindByIdGetway.findById(appointment.getDisponibility().
                getIdDisponibility());
        Patient patient = patientFindByIdGetway.findById(appointment.getPatient().getIdPatient());
        updateDisponibilityState(disponibility);
        appointment.setDisponibility(disponibility);
        appointment.setPatient(patient);
    }

    private void updateDisponibilityState(Disponibility disponibility) {
        disponibility.setDisponibilityState(DisponibilityState.BUSY);

        disponibilitySaveGetway.save(disponibility);
    }
}
