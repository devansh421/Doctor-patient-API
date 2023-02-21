package com.Divyanshu.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Divyanshu.models.Doctor;
import com.Divyanshu.services.DoctorService;

@RestController
@RequestMapping("doctor")
public class DoctroController 
{
	@Autowired DoctorService service;
	
	@PostMapping
	public ResponseEntity<Doctor> createResource(@Valid @RequestBody Doctor d)
	{
		Doctor dd=service.saveDoctor(d);
	    return ResponseEntity.status(HttpStatus.CREATED).body(dd);
	}
	@DeleteMapping("delete/{did}")
	public ResponseEntity<Doctor> deleteResource(@PathVariable int did)
	{
		Doctor dd=service.deleteDoctor(did);
	    return ResponseEntity.status(HttpStatus.OK).body(dd);
	}
}
