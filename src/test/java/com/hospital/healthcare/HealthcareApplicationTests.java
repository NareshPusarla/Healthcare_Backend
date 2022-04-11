package com.hospital.healthcare;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hospital.healthcare.model.Patients;
import com.hospital.healthcare.repository.PatientRepository;
import com.hospital.healthcare.service.PatientService;

@SpringBootTest
class HealthcareApplicationTests {
	
	@Mock
	public PatientRepository patientRepository;
	
	@Autowired
	public PatientService patientService;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetAllPatients() {
		patientService.getAllPatients();
		verify(patientRepository).findAll();
	}
	
}
