package com.app.appointment_app.appointment.infraestructure.entry_point;

import com.app.appointment_app.appointment.domain.exceptions.AppointmentException;
import com.app.appointment_app.appointment.domain.exceptions.CloseAppointmentException;
import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.dto.requests.CloseAppointmentRequest;
import com.app.appointment_app.appointment.domain.dto.responses.AppointmentPaginatorResponse;
import com.app.appointment_app.appointment.domain.dto.responses.CloseAppointmentResponse;
import com.app.appointment_app.appointment.domain.dto.responses.SaveAppointmentResponse;
import com.app.appointment_app.appointment.infraestructure.entry_point.provider.AppointmentProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
   private final AppointmentProvider appointmentProvider;
    public AppointmentController(AppointmentProvider appointmentProvider) {
        this.appointmentProvider = appointmentProvider;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> findById(@PathVariable Long id) {
        return new ResponseEntity<>(appointmentProvider.getAppointmentFindByIdUseCase()
                .findAppointmentById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<SaveAppointmentResponse> save(@RequestBody Appointment appointment) {
        return new ResponseEntity<>(
                appointmentProvider.getAppointmentSaveUseCase()
                        .saveAppointment(appointment), HttpStatus.CREATED);
    }
    @PostMapping("/closeAppointment")
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

    @GetMapping("/page/{numberPage}")
    public ResponseEntity<List<AppointmentPaginatorResponse>> getAppointmentPage(@PathVariable int numberPage) {
        return new ResponseEntity<>(appointmentProvider.getAppointmentFindAllUseCase()
                .findAllAppointmentPaginator(numberPage), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointmentById(@PathVariable Long id) {
        appointmentProvider.getAppointmentDeleteUseCase()
                .deleteAppointmentById(id);
        return new ResponseEntity<>("the entity with id " + id + " has been deleted", HttpStatus.OK);
    }
}
