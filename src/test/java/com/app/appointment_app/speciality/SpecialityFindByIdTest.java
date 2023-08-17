package com.app.appointment_app.speciality;

import com.app.appointment_app.speciality.domain.model.Speciality;
import com.app.appointment_app.speciality.domain.usecases.SpecialityFindByIdUseCase;
import com.app.appointment_app.speciality.infraestructure.entry_point.SpecialityController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SpecialityFindByIdTest {
    @Mock
    private SpecialityFindByIdUseCase specialityFindByIdUseCase;

    @InjectMocks
    private SpecialityController specialityController;

    @Test
    void testFindByIdSpeciality(){
        Speciality speciality = new Speciality();
        speciality.setIdSpeciality(1L);
        speciality.setGrade(1);
        speciality.setName("General");
        when(specialityFindByIdUseCase.findSpecialityById(speciality.getIdSpeciality()))
                .thenReturn(speciality);
        ResponseEntity<Speciality> response = specialityController.findById(speciality
                .getIdSpeciality());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(speciality, response.getBody()
        );
    }
}
