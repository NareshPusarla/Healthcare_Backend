package com.hospital.healthcare.service;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hospital.healthcare.exception.ResourceNotFoundException;
import com.hospital.healthcare.model.Patients;
import com.hospital.healthcare.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;

	//create record
	public Patients createPatient(Patients newPatient) {
		return patientRepository.save(newPatient);
	}

	// get all patients
	public List<Patients> getAllPatients() {
		return patientRepository.findAll();
	}

	// get patients by id
	public Patients getPatientsById(Long id) {
		return patientRepository.findById(id).orElse(null);
	}

	// update patients by id
	public ResponseEntity<Patients> updatePatient(Long id, Patients updatePatient) {
		Patients patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id: " + id));

		patient.setPatientName(updatePatient.getPatientName());
		patient.setPatientEmail(updatePatient.getPatientEmail());
		patient.setPatientAddress(updatePatient.getPatientAddress());
		patient.setPatientMobileNumber(updatePatient.getPatientMobileNumber());

		Patients updatedPatient = patientRepository.save(patient);
		return ResponseEntity.ok(updatedPatient);
	}

	// delete patient
	public ResponseEntity<Map<String, Boolean>> deletePatient(Long id) {
		Patients patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id: " + id));

		patientRepository.delete(patient);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
