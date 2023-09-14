package com.app.appointment_app.emergency_appointment.domain.model;




public class EmergencyAppointment {
    private Long idEmergencyAppointment;
    private String description;

    @Override
    public String toString() {
        return "EmergencyAppointment{" +
                "idEmergencyAppointment=" + idEmergencyAppointment +
                ", description='" + description + '\'' +
                '}';
    }

    public EmergencyAppointment(Long idEmergencyAppointment, String description) {
        this.idEmergencyAppointment = idEmergencyAppointment;
        this.description = description;
    }

    public EmergencyAppointment() {
    }

    public Long getIdEmergencyAppointment() {
        return idEmergencyAppointment;
    }

    public void setIdEmergencyAppointment(Long idEmergencyAppointment) {
        this.idEmergencyAppointment = idEmergencyAppointment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
