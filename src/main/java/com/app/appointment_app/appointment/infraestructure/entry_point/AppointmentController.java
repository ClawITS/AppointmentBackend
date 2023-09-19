package com.app.appointment_app.appointment.infraestructure.entry_point;

import com.app.appointment_app.appointment.domain.exceptions.AppointmentException;
import com.app.appointment_app.appointment.domain.exceptions.CloseAppointmentException;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.dto.requests.CloseAppointmentRequest;
import com.app.appointment_app.appointment.domain.dto.responses.AppointmentPaginatorResponse;
import com.app.appointment_app.appointment.domain.dto.responses.CloseAppointmentResponse;
import com.app.appointment_app.appointment.infraestructure.entry_point.provider.AppointmentProvider;
import com.app.appointment_app.commons.infraestructure.rest.dto.response.CustomResponse;
import com.app.appointment_app.commons.infraestructure.rest.entry_points.controller.GenericRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.appointment_app.appointment.domain.constants.AppointmentResponseMessages.APPOINTMENT_SUCCESSFULlY_SAVED;
import static com.app.appointment_app.appointment.infraestructure.entry_point.constants.AppointmentApiConstant.REQUEST_APPOINTMENT;

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
    public ResponseEntity<CustomResponse> save(@RequestBody Appointment appointment) {

        return ok(appointmentProvider.getAppointmentSaveUseCase().saveAppointment(appointment),APPOINTMENT_SUCCESSFULlY_SAVED,
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
