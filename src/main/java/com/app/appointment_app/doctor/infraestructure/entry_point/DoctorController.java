package com.app.appointment_app.doctor.infraestructure.entry_point;

import com.app.appointment_app.doctor.domain.model.Doctor;
import com.app.appointment_app.doctor.domain.useCases.DoctorDeleteUseCase;
import com.app.appointment_app.doctor.domain.useCases.DoctorFindAllUseCase;
import com.app.appointment_app.doctor.domain.useCases.DoctorFindByIdUseCase;
import com.app.appointment_app.doctor.domain.useCases.DoctorSaveUseCase;
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

    public DoctorController(DoctorSaveUseCase doctorSaveUseCase, DoctorDeleteUseCase doctorDeleteUseCase, DoctorFindByIdUseCase doctorFindByIdUseCase, DoctorFindAllUseCase doctorFindAllUseCase) {
        this.doctorSaveUseCase = doctorSaveUseCase;
        this.doctorDeleteUseCase = doctorDeleteUseCase;
        this.doctorFindByIdUseCase = doctorFindByIdUseCase;
        this.doctorFindAllUseCase = doctorFindAllUseCase;
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
}
