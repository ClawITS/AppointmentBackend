package com.app.appointment_app.patient;


import com.app.appointment_app.patient.domain.model.Patient;
import com.app.appointment_app.patient.domain.model.enums.Gender;
import com.app.appointment_app.patient.domain.usecases.PatientFindByIdUseCase;
import com.app.appointment_app.patient.infraestructure.entry_point.PatientController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PatientFindByIdTest {
    @Mock
    private PatientFindByIdUseCase patientFindByIdUseCase;

    @InjectMocks
    private PatientController patientController;

    @Test
    void testFindByIdPatient() {
        Patient patient = new Patient();

        Calendar calendar = Calendar.getInstance();
        calendar.set(1988, Calendar.FEBRUARY, 26);
        Date date = calendar.getTime();

        patient.setIdPatient(1L);
        patient.setName("Antonela Roccuzzo");
        patient.setDocument(1234567890);
        patient.setBirthDate(date);
        patient.setEmail("antonela@example.com");
        patient.setGender(Gender.FEMALE);

        when(patientFindByIdUseCase.findpatientById(patient.getIdPatient())).thenReturn(patient);

        ResponseEntity<Patient> response = patientController.findById(patient.getIdPatient());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(patient, response.getBody());
    }
}
