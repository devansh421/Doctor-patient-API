package com.Divyanshu.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Patient 
{
	@Id
	@GeneratedValue(generator = "pat_seq")
	@SequenceGenerator(name="pat_seq",initialValue = 1000,allocationSize = 1)
	private int pid;
	@NotNull(message = "Name is required")
	@Size(min = 3,message="Name should be at least 3 characters")
	private String name;
	@NotNull(message = "City is required")
	@Size(max = 20, message="City should have maximum 20 characters")
	private String city;
	@NotNull(message = "Email is required")
	@Email(message = "Email must be valid")
	private String email;
	@NotNull(message = "Phone is required")
	@Size(min = 10,message="Phone should be at least 10 characters")
	@Pattern(regexp = "[0-9]*",message ="Only digits alllowed" )
	private String phone;
	@NotNull(message = "Symptom is required")
	@Pattern(regexp = "Arthritis|Backpain|Tissue injuries|Dysmenorrhea|Skin infection|Skin burn|Ear pain",message = "Not a valid symptom")
	private String symptom;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	
}
