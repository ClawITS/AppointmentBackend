package com.app.Appointment.Appointment.domain.model;

import com.app.Appointment.Appointment.domain.model.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    private Long idAppointment;
    private State state;

}
