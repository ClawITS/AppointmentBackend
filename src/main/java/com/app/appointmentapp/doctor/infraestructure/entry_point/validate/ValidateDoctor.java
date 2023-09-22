package com.app.appointmentapp.doctor.infraestructure.entry_point.validate;

import com.app.appointmentapp.commons.infraestructure.rest.validators.Validator;
import com.app.appointmentapp.commons.infraestructure.rest.validators.ValidatorObject;
import com.app.appointmentapp.doctor.domain.model.Doctor;
import org.springframework.validation.BindingResult;

public class ValidateDoctor extends Validator {
    private static final String OBJ = "doctor";

    public static void validateDoctorFields(Doctor doctor, BindingResult bindingResult){
        validateSpecialityNotNull(doctor, bindingResult);
    }

    private static void validateSpecialityNotNull(Doctor doctor, BindingResult bindingResult) {
        if(doctor.getSpeciality() == null){
            validate(new ValidatorObject.ValidatorObjectBuilder()
                    .message("the speciality can not be null")
                    .object(OBJ)
                    .field("speciality")
                    .build(), bindingResult);
        }
    }
}
