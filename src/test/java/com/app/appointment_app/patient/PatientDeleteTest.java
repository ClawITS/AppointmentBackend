package com.app.appointment_app.patient;

import com.app.appointment_app.patient.domain.usecases.PatientDeleteUseCase;
import com.app.appointment_app.patient.infraestructure.entry_point.PatientController;
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
class PatientDeleteTest {
    @Mock
    private PatientDeleteUseCase patientDeleteUseCase;

    @InjectMocks
    private PatientController patientController;

    @Test
    void testDeletePatientById() {
        Long idToDelete = 3L;
        ResponseEntity<String> response = patientController.deletePatientById(idToDelete);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("the entity with id " + idToDelete + " has been deleted", response.getBody());

        verify(patientDeleteUseCase, times(1)).deletePatientById(idToDelete);
    }
}
