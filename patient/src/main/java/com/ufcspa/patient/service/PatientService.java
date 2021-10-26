package com.ufcspa.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcspa.patient.connector.PatientSandboxConnector;
import com.ufcspa.patient.model.Patient;

@Service
public class PatientService {
	
	
	@Autowired
	PatientSandboxConnector patientSandboxConnector;
	
	public List<Patient> getPatients(){
		return patientSandboxConnector.getPatients();
	}

}
