package com.hospital_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital_management.model.Patient;
import com.hospital_management.repository.PatientRepository;

@Service  
public class PatientService {
	
	@Autowired  
	PatientRepository patientRepository;  
	
	
	// update and save patient
	public Patient createPatient(Patient patient)   
	{  
	return patientRepository.save(patient);  
	}  
	
	// delete patient using id 
	public void delete(long id)   
	{  
		patientRepository.deleteById(id);  
	}  
	
	
	
}
