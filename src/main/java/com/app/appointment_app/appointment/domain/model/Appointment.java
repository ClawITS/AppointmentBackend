package com.app.appointment_app.appointment.domain.model;

import com.app.appointment_app.appointment.domain.model.enums.State;
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
