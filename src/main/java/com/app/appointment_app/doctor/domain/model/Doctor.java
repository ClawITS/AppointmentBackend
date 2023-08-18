package com.app.appointment_app.doctor.domain.model;


import com.app.appointment_app.disponibility.domain.model.Disponibility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    private Long idDoctor;
    private String name;
    private String description;
    private List<Disponibility> disponibilities;
}
