package com.app.appointment_app.speciality;

import com.app.appointment_app.speciality.domain.usecases.SpecialityDeleteUseCase;
import com.app.appointment_app.speciality.infraestructure.entry_point.SpecialityController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SpecialityDeleteTest {
    @Mock
    private SpecialityDeleteUseCase specialityDeleteUseCase;

    @InjectMocks
    private SpecialityController specialityController;

    @Test
    void testDeleteSpecialityById(){
        Long idToDelete = 2L; // ID a eliminar

        ResponseEntity<String> response = specialityController.deleteSpecialityById(idToDelete);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("the entity with id " + idToDelete + " has been deleted", response.getBody());

        verify(specialityDeleteUseCase, times(1)).deleteSpecialityById(idToDelete);
    }
}
