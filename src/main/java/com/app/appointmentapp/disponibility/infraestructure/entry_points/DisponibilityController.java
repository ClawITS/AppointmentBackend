package com.app.appointmentapp.disponibility.infraestructure.entry_points;

import com.app.appointmentapp.commons.infraestructure.rest.dto.response.CustomResponse;
import com.app.appointmentapp.commons.infraestructure.rest.entry_points.controller.GenericRestController;
import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.domain.requests.DisponibilityFilterByDoctorAndHourRequest;
import com.app.appointmentapp.disponibility.domain.requests.DisponibilityFilterByHourRequest;
import com.app.appointmentapp.disponibility.domain.requests.DisponibilitySaveRequest;
import com.app.appointmentapp.disponibility.infraestructure.entry_points.provider.DisponibilityProvider;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.app.appointmentapp.disponibility.infraestructure.entry_points.constants.DisponibilityApiConstant.REQUEST_DISPONIBILITY;
import static com.app.appointmentapp.disponibility.infraestructure.entry_points.constants.DisponibilityResponseConstant.DISPONIBILITY_SAVED;


@RestController
@RequestMapping("/api/disponibilities")
public class DisponibilityController extends GenericRestController implements IDisponibilityController {

    private final DisponibilityProvider disponibilityProvider;

    public DisponibilityController(DisponibilityProvider disponibilityProvider) {
        this.disponibilityProvider = disponibilityProvider;
    }

    @Override
    public ResponseEntity<Page<Disponibility>>findAllDisponibilities(@PathVariable int numberPage){
        return new ResponseEntity<>(disponibilityProvider
                .getDisponibilityFindAllUseCase().findAllDisponibilityPaginator(numberPage)
        , HttpStatus.OK);
    }
    @Override
    public ResponseEntity<CustomResponse>saveDisponibility(@RequestBody DisponibilitySaveRequest disponibilitySaveRequest){
        return create(disponibilityProvider
                .getDisponibilitySaveUseCase().saveDisponibility(disponibilitySaveRequest)
                , DISPONIBILITY_SAVED, REQUEST_DISPONIBILITY);
    }
    @Override
    public ResponseEntity<CustomResponse>findDisponibilityById(@PathVariable Long id){
        return ok(disponibilityProvider.dispibilityGetByIdMapper()
                .toDisponibilityResponse(disponibilityProvider
                        .getDisponibilityFindByIdUseCase()
                        .findDisponibilityById(id)),"finded",REQUEST_DISPONIBILITY);
    }
    @Override
    public ResponseEntity<String>deleteDisponibilityById(@PathVariable Long id){
        disponibilityProvider.getDisponibilityDeleteUseCase().deleteDisponibilityById(id);
        return new ResponseEntity<>( "the disponibility with id "+ id +" has been deleted",
                HttpStatus.OK);
    }
    @Override
    public ResponseEntity<List<Disponibility>>filterDisponibilityByHourRange(@RequestBody DisponibilityFilterByHourRequest
                                                                                     disponibilityFilterByHourRequest){
        return new ResponseEntity<>(disponibilityProvider
                .getDisponibilityFilterByHourUseCase().findDisponibilitiesByHour(disponibilityFilterByHourRequest)
                ,HttpStatus.OK);
    }
    @Override
    public ResponseEntity<List<Disponibility>>filterDisponibilityByDoctorAndHourRange(@RequestBody DisponibilityFilterByDoctorAndHourRequest
                                                                                              disponibilityFilterByDoctorAndHourRequest){
        return new ResponseEntity<>(disponibilityProvider
                .getDisponibilityFilterByDoctorAndHourUseCase().filterDisponibilittyByDoctorAndHour(disponibilityFilterByDoctorAndHourRequest)
                ,HttpStatus.OK);
    }

}
