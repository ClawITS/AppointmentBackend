package com.app.appointment_app.speciality.infraestructure.entry_point;

import com.app.appointment_app.speciality.domain.getways.SpecialityFindByIdGetway;
import com.app.appointment_app.speciality.domain.model.Speciality;
import com.app.appointment_app.speciality.domain.usecases.SpecialityDeleteUseCase;
import com.app.appointment_app.speciality.domain.usecases.SpecialityFindAllUseCase;
import com.app.appointment_app.speciality.domain.usecases.SpecialityFindByIdUseCase;
import com.app.appointment_app.speciality.domain.usecases.SpecialitySaveUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/specialities")
@RequiredArgsConstructor
public class SpecialityController {
    private final SpecialityFindByIdUseCase specialityFindByIdUseCase;
    private final SpecialitySaveUseCase specialitySaveUseCase;
    private final SpecialityFindAllUseCase specialityFindAllUseCase;
    private final SpecialityDeleteUseCase specialityDeleteUseCase;
    @GetMapping("/{id}")
    public ResponseEntity<Speciality> findById(@PathVariable Long id){
        return new ResponseEntity<>(specialityFindByIdUseCase.findSpecialityById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Speciality>save(@RequestBody Speciality speciality){
        return new ResponseEntity<>(specialitySaveUseCase.saveSpeciality(speciality), HttpStatus.CREATED);
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
