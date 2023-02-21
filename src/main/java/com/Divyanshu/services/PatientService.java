package com.Divyanshu.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Divyanshu.exception.RecordNotFoundException;
import com.Divyanshu.models.Doctor;
import com.Divyanshu.models.Patient;
import com.Divyanshu.repositories.DoctorRepo;
import com.Divyanshu.repositories.PatientRepo;
import com.Divyanshu.repositories.SuggestDoctor;
import com.Divyanshu.util.DoctorPatient;

@Service
public class PatientService 
{
	@Autowired PatientRepo repo;
	@Autowired DoctorRepo drepo;
	public Patient savePatient(Patient p)
	{
		return repo.save(p);
	}
	public List<Doctor> getDoctorList(int pid)
	{
		Patient p=repo.findById(pid).orElse(null);
		if(p==null)
		{
			throw new RecordNotFoundException("Patient with id "+pid+" not found");
		}
		String city=p.getCity();
		if(!city.equals("Noida") && !city.equals("Faridabad") && !city.equals("Delhi"))
		{
			throw new RecordNotFoundException("We are still waiting to expand to your location");
		}
		String speciality=DoctorPatient.map.get(p.getSymptom());
		/*List<Doctor> dlist=drepo.findByCity(city);
		List<Doctor> list=dlist.stream().filter(doctor->doctor.getSpeciality().equals(speciality)).collect(Collectors.toList());
		if(list.isEmpty())
		{
			throw new RecordNotFoundException("There isn’t any doctor present at your location for your symptom");
		}*/
		List<Doctor> list=drepo.findByCityAndSpeciality(city,speciality);
		if(list.isEmpty())
		{
			throw new RecordNotFoundException("There isn’t any doctor present at your location for your symptom");
		}
		return list;
	}
	public Patient deletePatient(int pid)
	{
		Patient p=repo.findById(pid).orElse(null);
		if(p==null)
			throw new RecordNotFoundException("Patient with id "+pid+" does not exist");
		repo.delete(p);
		return p;
	}
}
