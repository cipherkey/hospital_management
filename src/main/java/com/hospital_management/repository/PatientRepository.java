package com.hospital_management.repository;

import java.util.List;
import java.util.List;
import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital_management.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	List<Patient> findAll();

	//void save(int patient_id);
	
	
	
	
}