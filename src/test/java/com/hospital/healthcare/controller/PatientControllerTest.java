package com.hospital.healthcare.controller;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hospital.healthcare.model.Patients;
import com.hospital.healthcare.service.PatientService;


@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
	
//	@InjectMocks
	@Autowired
	public PatientController patientController;
	
//	@InjectMocks
	@Autowired
	public PatientService patientService;
	
	@Test
	public void testGetAllPatients() {
		patientController.getAllPatients();
		verify(patientService).getAllPatients();
	}
	
	@Test
	public void testCreatePatient() {
		Patients addPatients = new Patients(1,"Nani","jhhgsdja","test@gmail.com",789456123);
		patientController.createPatient(addPatients);
		verify(patientService).createPatient(addPatients);
	}
	
	@Test
	public void testGetPatientsById() {
		patientController.getPatientsById(1L);
		verify(patientService).getPatientsById(1L);
	}
	
	@Test
	public void testUpdate() {
		Patients updatePatients = new Patients(1,"Nani","jhhgsdja","test@gmail.com",789456123);
		patientController.updatePatient(1L, updatePatients);
		verify(patientService).updatePatient(1L, updatePatients);
	}
	
	@Test
	public void testDeletePatient() {
		patientController.deletePatient(1L);
		verify(patientService).deletePatient(1L);
	}
}
