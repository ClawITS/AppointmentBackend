package com.app.appointment_app.appointment.infraestructure.entry_point;

import com.app.appointment_app.appointment.domain.model.Appointment;
import com.app.appointment_app.appointment.domain.model.enums.State;
import com.app.appointment_app.appointment.domain.usecases.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
    private final AppointmentSaveUseCase appointmentSaveUseCase;
    private final AppointmentFindAllUseCase appointmentFindAllUseCase;
    private final AppointmentFindByIdUseCase appointmentFindByIdUseCase;
    private final AppointmentDeleteUseCase appointmentDeleteUseCase;
    private final CloseAppointmentUseCase closeAppointmentUseCase;

    public AppointmentController(AppointmentSaveUseCase appointmentSaveUseCase, AppointmentFindAllUseCase appointmentFindAllUseCase, AppointmentFindByIdUseCase appointmentFindByIdUseCase, AppointmentDeleteUseCase appointmentDeleteUseCase, CloseAppointmentUseCase closeAppointmentUseCase) {
        this.appointmentSaveUseCase = appointmentSaveUseCase;
        this.appointmentFindAllUseCase = appointmentFindAllUseCase;
        this.appointmentFindByIdUseCase = appointmentFindByIdUseCase;
        this.appointmentDeleteUseCase = appointmentDeleteUseCase;
        this.closeAppointmentUseCase = closeAppointmentUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> findById(@PathVariable Long id) {
        return new ResponseEntity<>(appointmentFindByIdUseCase.findAppointmentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Appointment> save(@RequestBody Appointment appointment) {
        return new ResponseEntity<>(appointmentSaveUseCase.saveAppointment(appointment), HttpStatus.CREATED);
    }
    @PostMapping("/closeAppointment")
    public ResponseEntity<Appointment>closeAppointment(@RequestBody Appointment appointment){
        if(appointment.getState().equals(State.EARRING)){

        }
        return new ResponseEntity<>(closeAppointmentUseCase.closeAppointment(appointment),
                HttpStatus.OK);
    }

    @GetMapping("/page/{numberPage}")
    public ResponseEntity<Page<Appointment>> getAppointmentPage(@PathVariable int numberPage) {
        return new ResponseEntity<>(appointmentFindAllUseCase.findAllAppointmentPaginator(numberPage), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointmentById(@PathVariable Long id) {
        appointmentDeleteUseCase.deleteAppointmentById(id);
        return new ResponseEntity<>("the entity with id " + id + " has been deleted", HttpStatus.OK);
    }
}
