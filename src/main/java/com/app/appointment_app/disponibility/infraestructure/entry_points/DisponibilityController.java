package com.app.appointment_app.disponibility.infraestructure.entry_points;

import com.app.appointment_app.disponibility.domain.model.Disponibility;
import com.app.appointment_app.disponibility.domain.requests.DisponibilityFilterByDoctorAndHourRequest;
import com.app.appointment_app.disponibility.domain.requests.DisponibilityFilterByHourRequest;
import com.app.appointment_app.disponibility.domain.requests.DisponibilitySaveRequest;
import com.app.appointment_app.disponibility.infraestructure.entry_points.provider.DisponibilityProvider;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disponibilities")
public class DisponibilityController {

    private final DisponibilityProvider disponibilityProvider;

    public DisponibilityController(DisponibilityProvider disponibilityProvider) {
        this.disponibilityProvider = disponibilityProvider;
    }

    @GetMapping("/page/{numberPage}")
    public ResponseEntity<Page<Disponibility>>findAllDisponibilities(@PathVariable int numberPage){
        return new ResponseEntity<>(disponibilityProvider
                .getDisponibilityFindAllUseCase().findAllDisponibilityPaginator(numberPage)
        , HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Disponibility>saveDisponibility(@RequestBody DisponibilitySaveRequest disponibilitySaveRequest){
        return new ResponseEntity<>(disponibilityProvider
                .getDisponibilitySaveUseCase().saveDisponibility(disponibilitySaveRequest),
                HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Disponibility>findDisponibilityById(@PathVariable Long id){
        return new ResponseEntity<>(disponibilityProvider
                .getDisponibilityFindByIdUseCase().findDisponibilityById(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteDisponibilityById(@PathVariable Long id){
        disponibilityProvider.getDisponibilityDeleteUseCase().deleteDisponibilityById(id);
        return new ResponseEntity<>( "the disponibility with id "+ id +" has been deleted",
                HttpStatus.OK);
    }
    @PostMapping("/filter-hour-range")
    public ResponseEntity<List<Disponibility>>filterDisponibilityByHourRange(@RequestBody DisponibilityFilterByHourRequest
                                                                             disponibilityFilterByHourRequest){
        return new ResponseEntity<>(disponibilityProvider
                .getDisponibilityFilterByHourUseCase().findDisponibilitiesByHour(disponibilityFilterByHourRequest)
                ,HttpStatus.OK);
    }
    @PostMapping("/filter-hour-range-doctor")
    public ResponseEntity<List<Disponibility>>filterDisponibilityByDoctorAndHourRange(@RequestBody DisponibilityFilterByDoctorAndHourRequest
                                                                                     disponibilityFilterByDoctorAndHourRequest){
        return new ResponseEntity<>(disponibilityProvider
                .getDisponibilityFilterByDoctorAndHourUseCase().filterDisponibilittyByDoctorAndHour(disponibilityFilterByDoctorAndHourRequest)
                ,HttpStatus.OK);
    }

}
