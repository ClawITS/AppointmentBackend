package com.app.appointment_app.speciality;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.app.appointment_app.speciality.domain.model.Speciality;
import com.app.appointment_app.speciality.domain.usecases.SpecialitySaveUseCase;
import com.app.appointment_app.speciality.infraestructure.entry_point.SpecialityController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class SpecialitySaveTest {

    @Mock
    private SpecialitySaveUseCase specialitySaveUseCase;

    @InjectMocks
    private SpecialityController specialityController;

    @Test
    void testSaveSpeciality() {
        Speciality speciality = new Speciality();
        speciality.setIdSpeciality(1L);
        speciality.setGrade(1);
        speciality.setName("General");
        when(specialitySaveUseCase.saveSpeciality(speciality)).thenReturn(speciality);

        ResponseEntity<Speciality> response = specialityController.save(speciality);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(speciality, response.getBody());

        verify(specialitySaveUseCase, times(1)).saveSpeciality(speciality);
    }
}

