package com.app.appointmentapp.patient.infraestructure.entry_point.validate;
import com.app.appointmentapp.appointment.domain.model.enums.State;
import com.app.appointmentapp.commons.infraestructure.rest.validators.Validator;
import com.app.appointmentapp.commons.infraestructure.rest.validators.ValidatorObject;
import com.app.appointmentapp.patient.domain.model.Patient;
import com.app.appointmentapp.patient.domain.requests.AcceptReschedulingRequest;
import org.springframework.validation.BindingResult;
import java.time.LocalDate;
import java.time.ZoneId;

import static com.app.appointmentapp.appointment.domain.constants.ReschedulingMessages.INVALID_STATE;

public class ValidatePatient extends Validator {
    private static final String OBJ = "patient";

    public static void validatePatientRows(Patient patient, BindingResult bindingResult){
        birthDateNotNull(patient, bindingResult);
        nameNotNull(patient, bindingResult);
        documentNotNull(patient, bindingResult);
        emailValidate(patient, bindingResult);
        genderNotNull(patient, bindingResult);
    }
    public static void validatePatientAcceptRechedule(AcceptReschedulingRequest acceptReschedulingRequest, BindingResult bindingResult){
        if(!acceptReschedulingRequest.getState().equals(State.EARRING)){
            validate(new ValidatorObject.ValidatorObjectBuilder()
                    .message(INVALID_STATE)
                    .field("state")
                    .object("acceptReschedulingRequest").build(), bindingResult);
        }
    }

    private static void genderNotNull(Patient patient, BindingResult bindingResult) {
        if(patient.getGender() == null){
            validate(new ValidatorObject.ValidatorObjectBuilder()
                    .message("the gender can not be null")
                    .field("gender")
                    .object(OBJ).build(), bindingResult);
        }
    }

    private static void emailValidate(Patient patient, BindingResult bindingResult) {
        if(patient.getEmail() == null){
            validate(new ValidatorObject.ValidatorObjectBuilder()
                    .message("the email can not be null")
                    .field("email")
                    .object(OBJ).build(), bindingResult);
        }
        if(!patient.getEmail().contains("@")){
            validate(new ValidatorObject.ValidatorObjectBuilder()
                    .message("the email is incorrect")
                    .field("email")
                    .object(OBJ).build(), bindingResult);
        }
    }

    private static void documentNotNull(Patient patient, BindingResult bindingResult) {
        if(patient.getDocument() == null){
            validate(new ValidatorObject.ValidatorObjectBuilder()
                    .message("the document can not be null")
                    .field("document")
                    .object(OBJ).build(), bindingResult);
        }
    }

    private static void nameNotNull(Patient patient, BindingResult bindingResult) {
        if(patient.getName() == null){
            validate(new ValidatorObject.ValidatorObjectBuilder()
                    .message("the name can not be null")
                    .field("name")
                    .object(OBJ).build(), bindingResult);
        }
    }

    private static void birthDateNotNull(Patient patient, BindingResult bindingResult) {
        if(patient.getBirthDate() == null){
            validate(new ValidatorObject.ValidatorObjectBuilder()
                    .message("the birth date can not be null")
                    .field("birthDate")
                    .object(OBJ).build(), bindingResult);
        }
        if(patient.getBirthDate()
                .toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isAfter(LocalDate.now()
        )){
            validate(new ValidatorObject.ValidatorObjectBuilder()
                    .message("the birth date can not be major than actual date")
                    .field("birthDate")
                    .object(OBJ).build(), bindingResult);
        }
    }
}
