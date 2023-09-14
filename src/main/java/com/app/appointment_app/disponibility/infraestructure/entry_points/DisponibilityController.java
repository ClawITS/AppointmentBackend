package com.app.appointment_app.disponibility.infraestructure.entry_points;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.requests.DisponibilityFilterByDoctorAndHourRequest;
import com.app.appointment_app.disponibility.domain.requests.DisponibilityFilterByHourRequest;
import com.app.appointment_app.disponibility.domain.requests.DisponibilitySaveRequest;
import com.app.appointment_app.disponibility.domain.usecases.filters.DisponibilityFilterByDoctorAndHourUseCase;
import com.app.appointment_app.disponibility.domain.usecases.filters.DisponibilityFilterByHourUseCase;
import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilityDeleteUseCase;
import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilityFindAllUseCase;
import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilityFindByIdUseCase;
import com.app.appointment_app.disponibility.domain.usecases.cruds.DisponibilitySaveUseCase;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disponibilities")
public class DisponibilityController {
    private final DisponibilitySaveUseCase disponibilitySaveUseCase;
    private final DisponibilityDeleteUseCase disponibilityDeleteUseCase;
    private final DisponibilityFindAllUseCase disponibilityFindAllUseCase;
    private final DisponibilityFindByIdUseCase disponibilityFindByIdUseCase;
    private final DisponibilityFilterByHourUseCase disponibilityFilterByHourUseCase;
    private final DisponibilityFilterByDoctorAndHourUseCase disponibilityFilterByDoctorAndHourUseCase;

    public DisponibilityController(DisponibilitySaveUseCase disponibilitySaveUseCase, DisponibilityDeleteUseCase
            disponibilityDeleteUseCase, DisponibilityFindAllUseCase disponibilityFindAllUseCase, DisponibilityFindByIdUseCase disponibilityFindByIdUseCase, DisponibilityFilterByHourUseCase disponibilityFilterByHourUseCase, DisponibilityFilterByDoctorAndHourUseCase disponibilityFilterByDoctorAndHourUseCase) {
        this.disponibilitySaveUseCase = disponibilitySaveUseCase;
        this.disponibilityDeleteUseCase = disponibilityDeleteUseCase;
        this.disponibilityFindAllUseCase = disponibilityFindAllUseCase;
        this.disponibilityFindByIdUseCase = disponibilityFindByIdUseCase;
        this.disponibilityFilterByHourUseCase = disponibilityFilterByHourUseCase;
        this.disponibilityFilterByDoctorAndHourUseCase = disponibilityFilterByDoctorAndHourUseCase;
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
    @PostMapping("/filter-hour-range")
    public ResponseEntity<List<Disponibility>>filterDisponibilityByHourRange(@RequestBody DisponibilityFilterByHourRequest
                                                                             disponibilityFilterByHourRequest){
        return new ResponseEntity<>(disponibilityFilterByHourUseCase.findDisponibilitiesByHour(disponibilityFilterByHourRequest)
                ,HttpStatus.OK);
    }
    @PostMapping("/filter-hour-range-doctor")
    public ResponseEntity<List<Disponibility>>filterDisponibilityByDoctorAndHourRange(@RequestBody DisponibilityFilterByDoctorAndHourRequest
                                                                                     disponibilityFilterByDoctorAndHourRequest){
        return new ResponseEntity<>(disponibilityFilterByDoctorAndHourUseCase.filterDisponibilittyByDoctorAndHour(disponibilityFilterByDoctorAndHourRequest)
                ,HttpStatus.OK);
    }

}
