package com.app.appointment_app.disponibility.infraestructure.entry_points;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.requests.DisponibilitySaveRequest;
import com.app.appointment_app.disponibility.domain.usecases.DisponibilityDeleteUseCase;
import com.app.appointment_app.disponibility.domain.usecases.DisponibilityFindAllUseCase;
import com.app.appointment_app.disponibility.domain.usecases.DisponibilityFindByIdUseCase;
import com.app.appointment_app.disponibility.domain.usecases.DisponibilitySaveUseCase;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/disponibilities")
public class DisponibilityController {
    private final DisponibilitySaveUseCase disponibilitySaveUseCase;
    private final DisponibilityDeleteUseCase disponibilityDeleteUseCase;
    private final DisponibilityFindAllUseCase disponibilityFindAllUseCase;
    private final DisponibilityFindByIdUseCase disponibilityFindByIdUseCase;

    public DisponibilityController(DisponibilitySaveUseCase disponibilitySaveUseCase, DisponibilityDeleteUseCase
            disponibilityDeleteUseCase, DisponibilityFindAllUseCase disponibilityFindAllUseCase, DisponibilityFindByIdUseCase disponibilityFindByIdUseCase) {
        this.disponibilitySaveUseCase = disponibilitySaveUseCase;
        this.disponibilityDeleteUseCase = disponibilityDeleteUseCase;
        this.disponibilityFindAllUseCase = disponibilityFindAllUseCase;
        this.disponibilityFindByIdUseCase = disponibilityFindByIdUseCase;
    }
    @GetMapping("/page/{numberPage}")
    public ResponseEntity<Page<Disponibility>>findAllDisponibilities(@PathVariable int numberPage){
        return new ResponseEntity<>(disponibilityFindAllUseCase.findAllDisponibilityPaginator(numberPage)
        , HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Disponibility>saveDisponibility(@RequestBody DisponibilitySaveRequest disponibilitySaveRequest){
        return new ResponseEntity<>(disponibilitySaveUseCase.saveDisponibility(disponibilitySaveRequest),
                HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Disponibility>findDisponibilityById(@PathVariable Long id){
        return new ResponseEntity<>(disponibilityFindByIdUseCase.findDisponibilityById(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteDisponibilityById(@PathVariable Long id){
        disponibilityDeleteUseCase.deleteDisponibilityById(id);
        return new ResponseEntity<>( "the disponibility with id "+ id +" has been deleted",
                HttpStatus.OK);
    }

}
