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
	public Patients getPatientsById(Long id) throws ResourceNotFoundException {
//		return patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id: " + id));
		Patients patients = patientRepository.findByPatientId(id);
		if(patients != null) {
			return patients;
		}else {
			throw new ResourceNotFoundException("User not found with this id: "+id);
		}
	}

	// update patients by id
	public ResponseEntity<Patients> updatePatient(Long id, Patients updatePatient) throws ResourceNotFoundException {
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
	public ResponseEntity<Map<String, Boolean>> deletePatient(Long id) throws ResourceNotFoundException {
		Patients patient = patientRepository.findByPatientId(id);
				
		if(patient != null) {
			patientRepository.delete(patient);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}else {
			throw new ResourceNotFoundException("User not found with this id: "+id);
		}
		

	}
	
}
