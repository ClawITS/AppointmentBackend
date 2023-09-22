package com.app.appointmentapp.commons.infraestructure.rest.entry_points.controller;
import com.app.appointmentapp.commons.infraestructure.rest.dto.response.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GenericRestController {
    public GenericRestController() {
        // TODO document why this constructor is empty
    }

    protected ResponseEntity<CustomResponse> create(Object obj, String message, String api ){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setApi(api);
        customResponse.setCode(HttpStatus.CREATED.toString());
        customResponse.setMessage(message);
        customResponse.setResponse(obj);
        return ResponseEntity.ok(customResponse);
    }
    protected ResponseEntity<CustomResponse> ok(Object obj, String message, String api ){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setApi(api);
        customResponse.setCode(HttpStatus.OK.toString());
        customResponse.setMessage(message);
        customResponse.setResponse(obj);
        return ResponseEntity.ok(customResponse);
    }

    protected ResponseEntity<CustomResponse> bad(Object obj,String message, String api ){
        CustomResponse customResponse = new CustomResponse();
        customResponse.setApi(api);
        customResponse.setCode(HttpStatus.BAD_REQUEST.toString());
        customResponse.setMessage(message);
        customResponse.setResponse(obj);
        return ResponseEntity.ok(customResponse);
    }



}
