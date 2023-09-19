package com.app.appointment_app.appointment.infraestructure.adapter.db.sql.mysql.entity;

import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.disponibility.infraestructure.adapter.db.sql.mysql.entity.DisponibilityData;
import com.app.appointment_app.patient.infraestructure.adapter.db.sql.mysql.entity.PatientData;
import jakarta.persistence.*;

@Entity(name = "appointments")
public class AppointmentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAppointment;
    @OneToOne
    @JoinColumn(name = "disponibility_id")
    private DisponibilityData disponibility;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientData patient;
    private State state;

    @Override
    public String toString() {
        return "AppointmentData{" +
                "idAppointment=" + idAppointment +
                ", disponibility=" + disponibility +
                ", patient=" + patient +
                ", state=" + state +
                '}';
    }

    public AppointmentData() {
    }

    public DisponibilityData getDisponibility() {
        return disponibility;
    }

    public void setDisponibility(DisponibilityData disponibility) {
        this.disponibility = disponibility;
    }

    public PatientData getPatientData() {
        return patient;
    }

    public void setPatientData(PatientData patientData) {
        this.patient = patientData;
    }

    public Long getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(Long idAppointment) {
        this.idAppointment = idAppointment;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static final class AppointmentDataBuilder {
        private Long idAppointment;
        private DisponibilityData disponibility;
        private PatientData patient;
        private State state;

        public AppointmentDataBuilder() {
            // TODO document why this constructor is empty
        }

        public static AppointmentDataBuilder anAppointmentData() {
            return new AppointmentDataBuilder();
        }

        public AppointmentDataBuilder idAppointment(Long idAppointment) {
            this.idAppointment = idAppointment;
            return this;
        }

        public AppointmentDataBuilder disponibility(DisponibilityData disponibility) {
            this.disponibility = disponibility;
            return this;
        }

        public AppointmentDataBuilder patient(PatientData patient) {
            this.patient = patient;
            return this;
        }

        public AppointmentDataBuilder state(State state) {
            this.state = state;
            return this;
        }

        public AppointmentData build() {
            AppointmentData appointmentData = new AppointmentData();
            appointmentData.setIdAppointment(idAppointment);
            appointmentData.setDisponibility(disponibility);
            appointmentData.setState(state);
            appointmentData.patient = this.patient;
            return appointmentData;
        }
    }
}
