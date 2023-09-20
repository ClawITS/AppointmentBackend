package com.app.appointmentapp.appointment.infraestructure.entry_point;

import com.app.appointmentapp.appointment.domain.exceptions.AppointmentException;
import com.app.appointmentapp.appointment.domain.exceptions.CloseAppointmentException;
import com.app.appointmentapp.appointment.domain.model.Appointment;
import com.app.appointmentapp.appointment.domain.dto.requests.CloseAppointmentRequest;
import com.app.appointmentapp.appointment.domain.dto.responses.AppointmentPaginatorResponse;
import com.app.appointmentapp.appointment.domain.dto.responses.CloseAppointmentResponse;
import com.app.appointmentapp.appointment.infraestructure.entry_point.provider.AppointmentProvider;
import com.app.appointmentapp.appointment.infraestructure.entry_point.validator.ValidateApoointment;
import com.app.appointmentapp.commons.infraestructure.rest.dto.response.CustomResponse;
import com.app.appointmentapp.commons.infraestructure.rest.entry_points.controller.GenericRestController;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.appointmentapp.appointment.domain.constants.AppointmentResponseMessages.APPOINTMENT_SUCCESSFULLY_SAVED;
import static com.app.appointmentapp.appointment.infraestructure.entry_point.constants.AppointmentApiConstant.REQUEST_APPOINTMENT;

@RestController
@RequestMapping(REQUEST_APPOINTMENT)
public class AppointmentController extends GenericRestController implements IAppointmentController {
   private final AppointmentProvider appointmentProvider;
    public AppointmentController(AppointmentProvider appointmentProvider) {
        this.appointmentProvider = appointmentProvider;
    }
    @Override
    public ResponseEntity<Appointment> findById(@PathVariable Long id) {
        return new ResponseEntity<>(appointmentProvider.getAppointmentFindByIdUseCase()
                .findAppointmentById(id), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<CustomResponse> save(@RequestBody @Valid Appointment appointment, BindingResult bindingResult) {
        ValidateApoointment.validateAppointmentFields(bindingResult, appointment);
        if(bindingResult.hasErrors()){
            return bad(appointment,bindingResult.getFieldError().getDefaultMessage(), REQUEST_APPOINTMENT);
        }
        return ok(appointmentProvider.getAppointmentSaveUseCase().saveAppointment(appointment),APPOINTMENT_SUCCESSFULLY_SAVED,
                REQUEST_APPOINTMENT);
    }
    @Override
    public ResponseEntity<CloseAppointmentResponse>closeAppointment(@RequestBody CloseAppointmentRequest closeAppointmentRequest){
        try{
            CloseAppointmentException.stateException(closeAppointmentRequest);
            return new ResponseEntity<>(
                    appointmentProvider.getCloseAppointmentUseCase().
                        closeAppointment(closeAppointmentRequest),
                    HttpStatus.OK);
        }catch(AppointmentException e){
            return ResponseEntity.badRequest().body(new CloseAppointmentResponse(
                    null, e.getMessage()
            ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CloseAppointmentResponse(
                    null, e.getMessage()));
        }

    }

    @Override
    public ResponseEntity<List<AppointmentPaginatorResponse>> getAppointmentPage(@PathVariable int numberPage) {
        return new ResponseEntity<>(appointmentProvider.getAppointmentFindAllUseCase()
                .findAllAppointmentPaginator(numberPage), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAppointmentById(@PathVariable Long id) {
        appointmentProvider.getAppointmentDeleteUseCase()
                .deleteAppointmentById(id);
        return new ResponseEntity<>("the entity with id " + id + " has been deleted", HttpStatus.OK);
    }
}
