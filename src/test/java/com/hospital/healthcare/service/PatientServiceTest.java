package com.hospital.healthcare.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hospital.healthcare.model.Patients;
import com.hospital.healthcare.repository.PatientRepository;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

	@Mock
	public PatientRepository patientRepository;
	
	@Autowired
	public PatientService patientService;
	
	@Test
	public void testGetAllPatients() {
		patientService.getAllPatients();
		verify(patientRepository).findAll();
	}
	
	@Test
	public void testCreatePatient() {
		Patients addPatients = new Patients(1,"Nani","jhhgsdja","test@gmail.com",789456123);
		patientService.createPatient(addPatients);
//		verify(patientRepository).save(addPatients);
		
//		assertEquals(addPatients.getPatientId(), patientService.getPatientsById(1L).getPatientId());
		assertNotNull(patientService.getPatientsById(1L));
	}
	
	@Test
	public void testGetPatientsById() {
		patientService.getPatientsById(1L);
		verify(patientRepository).findById(1L);
	}
	
	@Test
	public void testUpdate() {
		Patients updatePatients = new Patients(1,"Nani","jhhgsdja","test@gmail.com",789456123);
		patientService.updatePatient(1L, updatePatients);
		verify(patientRepository).save(updatePatients);
	}
	
	@Test
	public void testDeletePatient() {
		patientService.deletePatient(1L);
		verify(patientRepository).deleteById(1L);
	}
}
