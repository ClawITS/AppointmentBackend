package com.app.appointment_app.doctor.infraestructure.entry_point;
import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.domain.requests.RescheduleAppointmentRequest;
import com.app.appointment_app.doctor.domain.responses.RescheduleAppointmentResponse;
import com.app.appointment_app.doctor.domain.useCases.business_services.RescheduleAppointmentUseCase;
import com.app.appointment_app.doctor.domain.useCases.cruds.DoctorDeleteUseCase;
import com.app.appointment_app.doctor.domain.useCases.cruds.DoctorFindAllUseCase;
import com.app.appointment_app.doctor.domain.useCases.cruds.DoctorFindByIdUseCase;
import com.app.appointment_app.doctor.domain.useCases.cruds.DoctorSaveUseCase;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorSaveUseCase doctorSaveUseCase;
    private final DoctorDeleteUseCase doctorDeleteUseCase;
    private final DoctorFindByIdUseCase doctorFindByIdUseCase;
    private final DoctorFindAllUseCase doctorFindAllUseCase;
    private final RescheduleAppointmentUseCase rescheduleAppointmentUseCase;

    public DoctorController(DoctorSaveUseCase doctorSaveUseCase, DoctorDeleteUseCase doctorDeleteUseCase, DoctorFindByIdUseCase doctorFindByIdUseCase, DoctorFindAllUseCase doctorFindAllUseCase, RescheduleAppointmentUseCase rescheduleAppointmentUseCase) {
        this.doctorSaveUseCase = doctorSaveUseCase;
        this.doctorDeleteUseCase = doctorDeleteUseCase;
        this.doctorFindByIdUseCase = doctorFindByIdUseCase;
        this.doctorFindAllUseCase = doctorFindAllUseCase;
        this.rescheduleAppointmentUseCase = rescheduleAppointmentUseCase;
    }

    @PostMapping
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
        return new ResponseEntity<>(doctorSaveUseCase.saveDoctor(doctor), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctorById(@PathVariable Long id){
        doctorDeleteUseCase.deleteDoctorById(id);
        return new ResponseEntity<>("The doctor with id " + id + " has been deleted succesfuly", HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findDoctorById(@PathVariable Long id){
        return new ResponseEntity<>(doctorFindByIdUseCase.findDoctorById(id), HttpStatus.OK);
    }
    @GetMapping("/page/{numberPage}")
    public ResponseEntity<Page<Doctor>> findAllPageDoctors(@PathVariable int numberPage){
        return new ResponseEntity<>(doctorFindAllUseCase.findAllDoctorsPaginator(numberPage),HttpStatus.OK);
    }
    @PostMapping("/rescheduleAppointment")
    public ResponseEntity<RescheduleAppointmentResponse> rescheduleAppointment(@RequestBody RescheduleAppointmentRequest
                                                                                           rescheduleAppointmentRequest){
        return new ResponseEntity<>(rescheduleAppointmentUseCase.rescheduleAppointment(rescheduleAppointmentRequest),
                HttpStatus.OK);
    }
}
