package com.hospital.healthcare;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.hospital.healthcare.model.Patients;
import com.hospital.healthcare.repository.PatientRepository;
import com.hospital.healthcare.service.PatientService;

@RunWith(SpringRunner.class)
@SpringBootTest
class HealthcareApplicationTests {
	
	@MockBean
	public PatientRepository patientRepository;
	
	@Autowired
	public PatientService patientService;
	
	@Test
	public void testGetAllPatients() {
		when(patientRepository.findAll()).thenReturn(Stream
				.of(new Patients(111, "Naresh", "innis", "test@gmail.com", 852741963), new Patients(112, "Rajesh", "innis", "test@gmail.com", 952771963)).collect(Collectors.toList()));
		assertEquals(2, patientService.getAllPatients().size());
	}
	
	@Test
	public void savePatientTest() {
		Patients patients = new Patients(999, "Sahiti", "innis", "sahi@gmail.com", 857741963);
		when(patientRepository.save(patients)).thenReturn(patients);
		assertEquals(patients, patientService.createPatient(patients));
	}
	
	@Test
	public void deletePatientTest() {
		Patients patients = new Patients(999, "Sahiti", "innis", "sahi@gmail.com", 857741963);
		System.out.println("id "+patients.getPatientId());
		patientService.deletePatient(patients.getPatientId());
		verify(patientRepository, times(1)).deleteById(patients.getPatientId());
	}
}
