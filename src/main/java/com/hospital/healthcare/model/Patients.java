package com.hospital.healthcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="patients")
public class Patients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId;
	
	@Column(name = "name")
	@NotNull(message="name can't be null")
	@Min(value = 3, message="name should atleast 3 letters")
	private String patientName;
	
	@Column(name = "address")
	@NotNull(message="address can't be null")
	@Min(value = 10, message="name should atleast 10 letters")
	private String patientAddress;
	
	@Column(name = "email")
	@NotNull(message="email can't be null")
	@Email
	private String patientEmail;
	
	@Column(name = "mobileNumber")
	@NotNull(message="mobile number can't be null")
	@Min(value = 12, message="name should atleast 12 digits 10 + country code")
	private long patientMobileNumber;

	public Patients() {
		
	}
	
	public Patients(long patientId, String patientName, String patientAddress, String patientEmail,
			long patientMobileNumber) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAddress = patientAddress;
		this.patientEmail = patientEmail;
		this.patientMobileNumber = patientMobileNumber;
	}

	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public long getPatientMobileNumber() {
		return patientMobileNumber;
	}
	public void setPatientMobileNumber(long patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}

	@Override
	public String toString() {
		return "Patients [patientId=" + patientId + ", patientName=" + patientName + ", patientAddress="
				+ patientAddress + ", patientEmail=" + patientEmail + ", patientMobileNumber=" + patientMobileNumber
				+ "]";
	}
	
}
