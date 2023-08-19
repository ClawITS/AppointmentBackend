package com.app.appointment_app.patient;

import com.app.appointment_app.patient.domain.model.Patient;
import com.app.appointment_app.patient.domain.usecases.PatientFindAllUseCase;
import com.app.appointment_app.patient.domain.model.enums.Gender;
import com.app.appointment_app.patient.infraestructure.entry_point.PatientController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatientFindAllTest {
    @Mock
    private PatientFindAllUseCase patientFindAllUseCase;

    @InjectMocks
    private PatientController patientController;

    @Test
    void testFindAllPatient() {
        List<Patient> patients = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(1987, Calendar.JUNE, 24);
        Date date = calendar.getTime();
        patients.add(new Patient(1L, "Lionel Messi", 1234567890, date, "messi10@example.com", Gender.MALE));

        Page<Patient> patientPage = new PageImpl<>(patients);

        when(patientFindAllUseCase.findAllPatientPaginator(0)).thenReturn(patientPage);

        ResponseEntity<Page<Patient>> response = patientController.getPatientPage(0);

        verify(patientFindAllUseCase, times(1)).findAllPatientPaginator(0);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(patientPage, response.getBody());
    }
}
