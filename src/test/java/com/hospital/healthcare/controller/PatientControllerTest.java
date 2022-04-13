package com.hospital.healthcare.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Size;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.hospital.healthcare.model.Patients;
import com.hospital.healthcare.service.PatientService;

@RunWith(SpringRunner.class)
//@WebMvcTest(value = PatientController.class)
//@WithMockUser
public class PatientControllerTest {
	
	private MockMvc mockMvc;
	
	ObjectMapper objectMapper =  new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	
	@Mock
	private PatientService patientService;
	
	@InjectMocks
	private PatientController patientController;
	
	Patients patient1 = new Patients(997, "Akhil", "LB nagar", "akhi@gmail.com", 857741963);
	Patients patient2 = new Patients(998, "Sasi", "Kphb", "sasi@gmail.com", 963258741);
	Patients patient3 = new Patients(999, "Anil", "JNTU", "anil@gmail.com", 741258963);
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(mockMvc);
		mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
	}
	
	
	@Test
	public void getAllPatientsTest() throws Exception {
		List<Patients> records = new ArrayList<>(Arrays.asList(patient1,patient2,patient3));
		
		Mockito.when(patientService.getAllPatients()).thenReturn(records);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/patients").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect((ResultMatcher) MockMvcResultMatchers.jsonPath("$", records.size()));
	}
	
	
	
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	private PatientService patientService;
//	
//	Patients patients = new Patients(999, "Sahiti", "innis", "sahi@gmail.com", 857741963);
//
//	@Test
//	public void getPatientsTest() throws Exception {
//		Mockito.when(patientService.getAllPatients()).thenReturn((List<Patients>) patients);
//		
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/patients").accept(MediaType.APPLICATION_JSON);
//		
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		
//		String expected = "{patientId:999, patientName:Sahiti, patientAddress:innis, patientEmail:sahi@gmail.com, patientMobileNumber:857741963}";
//		JSONAssert.assertEquals(expected, result.getResponse()
//				.getContentAsString(), false);
//		assertEquals(2, patientService.getAllPatients().size());
//	}
	
	
////	@InjectMocks
//	@Autowired
//	public PatientController patientController;
//	
//	@MockBean
//	public PatientRepository patientRepository;
//	
//	@Autowired
//	public PatientService patientService;
//	
//	@Test
//	public void testGetAllPatients() {
//		patientController.getAllPatients();
//		verify(patientService).getAllPatients();
//	}
//	
//	@Test
//	public void testCreatePatient() {
//		Patients addPatients = new Patients(1,"Nani","jhhgsdja","test@gmail.com",789456123);
//		patientController.createPatient(addPatients);
//		verify(patientService).createPatient(addPatients);
//	}
//	
//	@Test
//	public void testGetPatientsById() {
//		patientController.getPatientsById(1L);
//		verify(patientService).getPatientsById(1L);
//	}
//	
//	@Test
//	public void testUpdate() {
//		Patients updatePatients = new Patients(1,"Nani","jhhgsdja","test@gmail.com",789456123);
//		patientController.updatePatient(1L, updatePatients);
//		verify(patientService).updatePatient(1L, updatePatients);
//	}
//	
//	@Test
//	public void testDeletePatient() {
//		patientController.deletePatient(1L);
//		verify(patientService).deletePatient(1L);
//	}

}
