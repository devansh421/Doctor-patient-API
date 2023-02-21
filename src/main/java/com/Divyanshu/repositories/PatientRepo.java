package com.Divyanshu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Divyanshu.models.Patient;

public interface PatientRepo extends JpaRepository<Patient,Integer>
{
}
