package com.app.appointmentapp.commons.infraestructure.rest.validators;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class Validator {

    protected static void validate(ValidatorObject validatorObject, BindingResult bindingResult){
        bindingResult.addError(
                new FieldError(validatorObject.getObject()
                        , validatorObject.getField(),
                        validatorObject.getMessage()));    }
}
