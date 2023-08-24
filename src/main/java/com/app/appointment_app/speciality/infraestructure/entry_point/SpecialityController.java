package com.app.appointment_app.speciality.infraestructure.entry_point;

import com.app.appointment_app.speciality.domain.exceptions.SpecialityException;
import com.app.appointment_app.speciality.domain.exceptions.SpecialityRowsValidation;
import com.app.appointment_app.speciality.domain.model.Speciality;
import com.app.appointment_app.speciality.domain.usecases.SpecialityDeleteUseCase;
import com.app.appointment_app.speciality.domain.usecases.SpecialityFindAllUseCase;
import com.app.appointment_app.speciality.domain.usecases.SpecialityFindByIdUseCase;
import com.app.appointment_app.speciality.domain.usecases.SpecialitySaveUseCase;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/specialities")
public class SpecialityController {
    private final SpecialityFindByIdUseCase specialityFindByIdUseCase;
    private final SpecialitySaveUseCase specialitySaveUseCase;
    private final SpecialityFindAllUseCase specialityFindAllUseCase;
    private final SpecialityDeleteUseCase specialityDeleteUseCase;

    public SpecialityController(SpecialityFindByIdUseCase specialityFindByIdUseCase, SpecialitySaveUseCase specialitySaveUseCase, SpecialityFindAllUseCase specialityFindAllUseCase, SpecialityDeleteUseCase specialityDeleteUseCase) {
        this.specialityFindByIdUseCase = specialityFindByIdUseCase;
        this.specialitySaveUseCase = specialitySaveUseCase;
        this.specialityFindAllUseCase = specialityFindAllUseCase;
        this.specialityDeleteUseCase = specialityDeleteUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Speciality> findById(@PathVariable Long id){
        return new ResponseEntity<>(specialityFindByIdUseCase.findSpecialityById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?>save(@RequestBody Speciality speciality){
        try {
            SpecialityRowsValidation.validateSpecialityRows(speciality);

             return new ResponseEntity<>(specialitySaveUseCase.saveSpeciality(speciality), HttpStatus.CREATED);
        } catch (SpecialityException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
    @GetMapping("/page/{numberPage}")
    public ResponseEntity<Page<Speciality>>getSpecialityPage(@PathVariable int numberPage){
        return new ResponseEntity<>(specialityFindAllUseCase.findAllSpecialityPaginator(numberPage),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteSpecialityById(@PathVariable Long id){
        specialityDeleteUseCase.deleteSpecialityById(id);
        return new ResponseEntity<>("the entity with id "+id + " has been deleted",HttpStatus.OK);
    }

}
