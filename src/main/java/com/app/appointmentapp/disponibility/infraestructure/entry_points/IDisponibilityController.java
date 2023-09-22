package com.app.appointmentapp.disponibility.infraestructure.entry_points;

import com.app.appointmentapp.commons.infraestructure.rest.dto.response.CustomResponse;
import com.app.appointmentapp.disponibility.domain.model.Disponibility;
import com.app.appointmentapp.disponibility.domain.requests.DisponibilityFilterByDoctorAndHourRequest;
import com.app.appointmentapp.disponibility.domain.requests.DisponibilityFilterByHourRequest;
import com.app.appointmentapp.disponibility.domain.requests.DisponibilitySaveRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.appointmentapp.commons.infraestructure.rest.entry_points.constants.GlobalApiConstant.GENERIC_PAGINATOR_PARAM;
import static com.app.appointmentapp.commons.infraestructure.rest.entry_points.constants.GlobalApiConstant.ID_PARAM;
import static com.app.appointmentapp.disponibility.infraestructure.entry_points.constants.DisponibilityApiConstant.FILTER_BY_DOCTOR_AND_HOUR;
import static com.app.appointmentapp.disponibility.infraestructure.entry_points.constants.DisponibilityApiConstant.FILTER_BY_RANGE;

public interface IDisponibilityController {
    @GetMapping(GENERIC_PAGINATOR_PARAM)
    ResponseEntity<Page<Disponibility>> findAllDisponibilities(@PathVariable int numberPage);

    @PostMapping
    ResponseEntity<CustomResponse> saveDisponibility(@RequestBody DisponibilitySaveRequest disponibilitySaveRequest);

    @GetMapping(ID_PARAM)
    ResponseEntity<CustomResponse> findDisponibilityById(@PathVariable Long id);

    @DeleteMapping(ID_PARAM)
    ResponseEntity<String> deleteDisponibilityById(@PathVariable Long id);

    @PostMapping(FILTER_BY_RANGE)
    ResponseEntity<List<Disponibility>> filterDisponibilityByHourRange(@RequestBody DisponibilityFilterByHourRequest
                                                                               disponibilityFilterByHourRequest);

    @PostMapping(FILTER_BY_DOCTOR_AND_HOUR)
    ResponseEntity<List<Disponibility>> filterDisponibilityByDoctorAndHourRange(@RequestBody DisponibilityFilterByDoctorAndHourRequest
                                                                                        disponibilityFilterByDoctorAndHourRequest);
}
