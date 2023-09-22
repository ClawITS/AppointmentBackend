package com.app.appointmentapp.appointment.infraestructure.entry_point.validator;

import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.commons.infraestructure.rest.validators.Validator;
import com.app.appointmentapp.commons.infraestructure.rest.validators.ValidatorObject;
import org.springframework.validation.BindingResult;


public class ValidateAppointment extends Validator {
    private static final String OBJ = "appointment";

    public static void validateAppointmentFields(BindingResult bindingResult, Appointment appointment){
        validateDisponibilityNotNull(bindingResult, appointment);
        validatePatientNotNull(bindingResult, appointment);
    }

    private static void validatePatientNotNull(BindingResult bindingResult, Appointment appointment) {
        if (appointment.getPatient() == null) {
            validate(new ValidatorObject.ValidatorObjectBuilder()
                    .object(OBJ)
                    .field("patient")
                    .message("Patient cannot be null")
                    .build(), bindingResult);
        }
    }

    private static void validateDisponibilityNotNull(BindingResult bindingResult, Appointment appointment) {
        if (appointment.getDisponibility() == null) {
            validate(new ValidatorObject.ValidatorObjectBuilder()
                    .object(OBJ)
                    .field("disponibility")
                    .message("Disponibility cannot be null")
                    .build(), bindingResult);
        }
    }

}
