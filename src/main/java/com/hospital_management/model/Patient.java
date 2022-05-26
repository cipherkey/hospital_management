package com.hospital_management.model;




import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table  
public class Patient {
			
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)		
		private long patient_id;
		
		@NotEmpty
		@Size(min = 3 ,message = "Patient Name Should be minimum 3 Charater")
		private String name;
		
		@NotEmpty
		@Size(min = 10 , message = "Address should be at 10 charater")
		private String address;
		
		@NotEmpty
		@Size(min = 8 ,max=15 , message = "Must be Minimum 8 charater and maximum 15 charater password required")
	    @Pattern(regexp="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Password must contain at least 1 number, 1 uppercase Alphabate , 1 lowercase charater And one Special Charater[@#$&] ")
        private String password;
		
		@NotEmpty
		@Email
		private String emailId;
		
		@NotEmpty
	    @Pattern(regexp= "^\\+(?:[0-9] ?){11}[0-9]$", message = "Enter The Contanct number with country code and number should be at least 10 number")
        private String contactNumber;
		
		//"+12 123456789"
		@Column(name="created_at")
		private Date createdAt;
	
		
		public Patient() {
			super();
		}
		
		
		
		
		

	public Patient( String name, String address,String password, String emailId, String contactNumber,Date createdAt) {
			super();
			this.name = name;
			this.address = address;
			this.password = password;
			this.emailId = emailId;
			this.contactNumber = contactNumber;
			this.createdAt = createdAt;
		}







		public long getPatient_id() {
		return patient_id;
	}


	public void setPatient_id(long patient_id) {
		this.patient_id = patient_id;
	}


		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}

		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}






		public Date getCreatedAt() {
			return createdAt;
		}






		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}



	

		
	}
