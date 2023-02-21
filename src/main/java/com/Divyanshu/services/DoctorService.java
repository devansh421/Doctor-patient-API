package com.Divyanshu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Divyanshu.exception.RecordNotFoundException;
import com.Divyanshu.models.Doctor;
import com.Divyanshu.repositories.DoctorRepo;

@Service
public class DoctorService
{
	@Autowired DoctorRepo repo;
	public Doctor saveDoctor(Doctor d)
	{
		return repo.save(d);
	}
	public Doctor deleteDoctor(int did)
	{
		Doctor d=repo.findById(did).orElse(null);
		if(d==null)
			throw new RecordNotFoundException("Doctor with id "+did+" does not exist");
		repo.delete(d);
		return d;
	}
}
