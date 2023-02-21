package com.Divyanshu.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Divyanshu.models.Doctor;
import com.Divyanshu.models.Patient;
import com.Divyanshu.services.PatientService;

@RestController
@RequestMapping("patient")
public class PatientController 
{
	@Autowired PatientService service;
	@PostMapping
	public ResponseEntity<Object> createResource(@Valid  @RequestBody Patient p)
	{
		Patient pp=service.savePatient(p);
	    return ResponseEntity.status(HttpStatus.CREATED).body(pp);
	}
	@DeleteMapping("{pid}")
	public ResponseEntity<Patient> deletePatient(@PathVariable int pid)
	{
		Patient p=service.deletePatient(pid);
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	@GetMapping("doctor-list")
	public ResponseEntity<List<Doctor>> getDoctorList(@RequestParam int pid)
	{
		List<Doctor> list=service.getDoctorList(pid);
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
}
