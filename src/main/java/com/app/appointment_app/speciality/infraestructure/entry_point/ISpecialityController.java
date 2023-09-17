package com.app.appointment_app.speciality.infraestructure.entry_point;

import com.app.appointment_app.commons.infraestructure.rest.dto.response.CustomResponse;
import com.app.appointment_app.speciality.domain.model.Speciality;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.app.appointment_app.commons.infraestructure.rest.entry_points.constants.GlobalApiConstant.*;

public interface ISpecialityController {
    @GetMapping(ID_PARAM)
    ResponseEntity<Speciality> findById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<CustomResponse> save(@RequestBody Speciality speciality);

    @GetMapping(GENERIC_PAGINATOR_PARAM)
    ResponseEntity<Page<Speciality>> getSpecialityPage(@PathVariable int numberPage);

    @DeleteMapping(ID_PARAM)
    ResponseEntity<String> deleteSpecialityById(@PathVariable Long id);
}
