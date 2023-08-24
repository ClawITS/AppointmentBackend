package com.app.appointment_app.speciality.domain.exceptions;

import com.app.appointment_app.speciality.domain.constants.validation.ValidationConstants;
import com.app.appointment_app.speciality.domain.model.Speciality;

import static java.util.Objects.isNull;

public class SpecialityRowsValidation {

    public static void validateSpecialityRows(Speciality speciality) throws SpecialityException {
        if(isNull(speciality.getName())){
            throw new SpecialityException(ValidationConstants.NOT_NULL_SPECIALITY_NAME);
        }

    }
}
