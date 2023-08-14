package com.app.Appointment.Disponibility.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Disponibility {
    private Long idDisponibility;
    private Date hour;
}
