package com.hospital.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.healthcare.model.Patients;

@Repository
public interface PatientRepository extends JpaRepository<Patients, Long> {
	Patients findByPatientId(Long id);
}
