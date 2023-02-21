package com.Divyanshu.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Doctor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	@NotEmpty(message = "Name is required")
	@Size(min = 3,message = "Name must have alteast 3 letters")
	private String name;
	@NotEmpty(message = "City is required")
	@Pattern(regexp = "Noida|Delhi|Faridabad",message = "City must be either Delhi or Noida or Faridabad")
	private String city;
	@NotEmpty(message = "Email is required")
	@Email(message = "Invalid email")
	private String email;
	@NotEmpty(message = "Phone is required")
	@Pattern(regexp = "[0-9]*",message = "Only digits are allowed in phone number")
	@Size(min = 10,message = "Phone number must have alteast 10 digits")
	private String phone;
	@NotEmpty(message = "Speciality is required")
	@Pattern(regexp = "Orthopedic|Gynecology|Dermatology|ENT",message = "Specialy must be one of following Orthopedic, Gynecology, Dermatology, ENT specialist")
	private String speciality;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
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
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	
	
}
