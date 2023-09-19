package com.app.appointmentapp.speciality.infraestructure.entry_point;

import com.app.appointmentapp.commons.infraestructure.rest.dto.response.CustomResponse;
import com.app.appointmentapp.commons.infraestructure.rest.entry_points.controller.GenericRestController;
import com.app.appointmentapp.speciality.domain.model.Speciality;

import com.app.appointmentapp.speciality.infraestructure.entry_point.provider.SpecialityProvider;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.app.appointmentapp.speciality.infraestructure.entry_point.constants.SpecialityApiConstant.REQUEST_SPECIALITY;
import static com.app.appointmentapp.speciality.infraestructure.entry_point.constants.SpecialityResponseConstant.SPECIALITY_SAVED;

@RestController
@RequestMapping(REQUEST_SPECIALITY)
public class SpecialityController extends GenericRestController implements ISpecialityController {
    private final SpecialityProvider specialityProvider;

    public SpecialityController(SpecialityProvider specialityProvider) {
        this.specialityProvider = specialityProvider;
    }

    @Override
    public ResponseEntity<Speciality> findById(@PathVariable Long id){
        return new ResponseEntity<>(specialityProvider
                .getSpecialityFindByIdUseCase().findSpecialityById(id), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<CustomResponse>save(@RequestBody Speciality speciality){
        return ok(specialityProvider
                .getSpecialitySaveUseCase().saveSpeciality(speciality),
                SPECIALITY_SAVED, REQUEST_SPECIALITY);
    }
    @Override
    public ResponseEntity<Page<Speciality>>getSpecialityPage(@PathVariable int numberPage){
        return new ResponseEntity<>(specialityProvider
                .getSpecialityFindAllUseCase().findAllSpecialityPaginator(numberPage),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<String>deleteSpecialityById(@PathVariable Long id){
        specialityProvider.getSpecialityDeleteUseCase().deleteSpecialityById(id);
        return new ResponseEntity<>("the entity with id "+id + " has been deleted",HttpStatus.OK);
    }

}
