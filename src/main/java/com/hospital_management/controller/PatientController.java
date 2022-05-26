package com.hospital_management.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_management.Exception.ResourceNotFoundException;
import com.hospital_management.model.Patient;
import com.hospital_management.repository.PatientRepository;
import com.hospital_management.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private PatientService patientService;
	
	
	// List All Patient ( GET - http://localhost:8080/patient )
	  @GetMapping("/patient")
	    public List<Patient> getAllUsers(){
	        return patientRepo.findAll();
	    }
	  
	 
  // Delete patient by id  ( DELETE - http://localhost:8080/patient/5 )
	  @DeleteMapping("/patient/{patient_id}")  
	  private void deleteBook(@PathVariable("patient_id") long patient_id)   
	  {  
	  patientService.delete(patient_id);  
	  } 
	  
	   
	 // add patient ( POST - http://localhost:8080/patient )
	  @PostMapping("/patient")
	    public ResponseEntity <Patient> createPatient(@Valid @RequestBody Patient patient) {
	      
		  Patient savePatient = patientService.createPatient(patient);
		  return new ResponseEntity <Patient>(savePatient,HttpStatus.CREATED);
	    }
	  
	  

   // update patient  (PUT - http://localhost:8080/patient/17  )
	   @PutMapping("/patient/{id}")
	    public ResponseEntity<Patient> updateProduct( @PathVariable Long id, @Valid @RequestBody Patient patientDetails)throws Exception{
	        Patient patient = patientRepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("product not exist with id :" + id));

	        patient.setName(patientDetails.getName());
	        patient.setAddress(patientDetails.getAddress());
	        patient.setPassword(patientDetails.getPassword());
	        patient.setEmailId(patientDetails.getEmailId());
	        patient.setContactNumber(patientDetails.getContactNumber());


	        Patient updatedProduct = patientRepo.save(patient);
	        return ResponseEntity.ok(updatedProduct);
	    }
	   
	   // sort patient at register by date ascending order (GET - http://localhost:8080/patientByDate?field=createdAt )
	   @GetMapping("/patientByDate")
		public List<Patient> getAll (@RequestParam String field) {
			return patientRepo.findAll(Sort.by(Direction.ASC, field));
		}
	
	
}
