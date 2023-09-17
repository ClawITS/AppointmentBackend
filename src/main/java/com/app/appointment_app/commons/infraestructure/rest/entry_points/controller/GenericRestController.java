package com.app.appointment_app.commons.infraestructure.rest.entry_points.controller;

import com.app.appointment_app.appointment.domain.dto.responses.SaveAppointmentResponse;
import com.app.appointment_app.commons.infraestructure.rest.dto.response.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.app.appointment_app.appointment.domain.constants.AppointmentResponseMessages.SAVE_SUCCESSFULlY;

public class GenericRestController {
    public GenericRestController() {
        // TODO document why this constructor is empty
    }

    protected ResponseEntity<CustomResponse> ok(Object obj){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setApi("api.appointment");
        customResponse.setCode(HttpStatus.CREATED.toString());
        customResponse.setMessage(SAVE_SUCCESSFULlY);
        customResponse.setResponse(obj);
        return ResponseEntity.ok(customResponse);
    }

    SaveAppointmentResponse saveAppointmentResponse = null;

}
