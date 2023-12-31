package com.app.Appointment.Patient.domain.model;

import com.app.Appointment.Patient.domain.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private Long idPatient;
    private Integer document;
    private Date birthDate;
    private String email;
    private Gender gender;
}
