package com.Divyanshu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Divyanshu.models.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor,Integer>
{
	List<Doctor> findByCity(String city);
	List<Doctor> findByCityAndSpeciality(String city,String speciality);
}
