package com.app.appointment_app.speciality.infraestructure.entry_point;

import com.app.appointment_app.speciality.domain.model.Speciality;

import com.app.appointment_app.speciality.infraestructure.entry_point.provider.SpecialityProvider;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/specialities")
public class SpecialityController {
    private final SpecialityProvider specialityProvider;

    public SpecialityController(SpecialityProvider specialityProvider) {
        this.specialityProvider = specialityProvider;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Speciality> findById(@PathVariable Long id){
        return new ResponseEntity<>(specialityProvider
                .getSpecialityFindByIdUseCase().findSpecialityById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Speciality>save(@RequestBody Speciality speciality){
        return new ResponseEntity<>(specialityProvider
                .getSpecialitySaveUseCase().saveSpeciality(speciality), HttpStatus.CREATED);
    }
    @GetMapping("/page/{numberPage}")
    public ResponseEntity<Page<Speciality>>getSpecialityPage(@PathVariable int numberPage){
        return new ResponseEntity<>(specialityProvider
                .getSpecialityFindAllUseCase().findAllSpecialityPaginator(numberPage),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteSpecialityById(@PathVariable Long id){
        specialityProvider.getSpecialityDeleteUseCase().deleteSpecialityById(id);
        return new ResponseEntity<>("the entity with id "+id + " has been deleted",HttpStatus.OK);
    }

}
