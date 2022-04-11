package com.hospital.healthcare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hospital.healthcare.model.Patients;
import com.hospital.healthcare.service.PatientService;

@RestController
@RequestMapping("/api/v1/")

public class PatientController {

	@Autowired
	public PatientService patientService;
	
	//get all patients
	@GetMapping("/patients")
	public List<Patients> getAllPatients(){
		return patientService.getAllPatients();
	}
	
	//create patient 
	@PostMapping("/addpatients")
	public Patients createPatient(@Valid @RequestBody Patients newPatient) {
		return patientService.createPatient(newPatient);
	}
	
	//get patients by id
	@GetMapping("/patients/{id}")
	public Patients getPatientsById(@PathVariable Long id){
		return patientService.getPatientsById(id);
	}
	
	//update patients by id
	@PutMapping("/updatepatients/{id}")
	public ResponseEntity<Patients> updatePatient(@PathVariable Long id, @RequestBody Patients updatePatient){
		return patientService.updatePatient(id, updatePatient);
	}
	
	//delete patient
	@DeleteMapping("/deletepatients/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id) {
		Patients patient = patientService.getPatientsById(id);
		
		patientService.deletePatient(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
