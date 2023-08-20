package com.app.appointment_app.disponibility.infraestructure.driver_adapter.jpa_repository;

import com.app.appointment_app.doctor.infraestructure.driver_adapter.jpa_repository.DoctorData;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "disponibilities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisponibilityData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisponibility;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date hour;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorData doctor;
}
