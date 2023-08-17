package com.app.appointment_app.speciality;

import com.app.appointment_app.speciality.domain.model.Speciality;
import com.app.appointment_app.speciality.domain.usecases.SpecialityFindAllUseCase;
import com.app.appointment_app.speciality.infraestructure.entry_point.SpecialityController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialityFindAllTest {
    @Mock
    private SpecialityFindAllUseCase specialityFindAllUseCase;

    @InjectMocks
    private SpecialityController specialityController;

    @Test
    void testFindAllSpeciality(){
        List<Speciality> specialities = new ArrayList<>();
        specialities.add(new Speciality(1L,"general",2));

        // Crear una instancia simulada de Page<Speciality>
        Page<Speciality> specialityPage = new PageImpl<>(specialities);

        when(specialityFindAllUseCase.findAllSpecialityPaginator(0)).thenReturn(specialityPage);

        ResponseEntity<Page<Speciality>> response = specialityController.getSpecialityPage(0);

        verify(specialityFindAllUseCase, times(1)).findAllSpecialityPaginator(0);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(specialityPage, response.getBody());
    }
}
