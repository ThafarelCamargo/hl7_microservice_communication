package com.ufcspa.patient.connector;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufcspa.patient.configuration.PatientServiceConfiguration;
import com.ufcspa.patient.model.Patient;

import fhir.foundation.resources.Bundle;
import fhir.foundation.resources.Entry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PatientSandboxConnector {
	
	@Autowired
	private PatientServiceConfiguration patientServiceConfiguration;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Patient> getPatients() {
		List<Patient> patientList = new ArrayList<Patient>();
		Patient response = restTemplate.getForObject(buildURIPatientList(), Patient.class);
		patientList.add(response);
//		for (Patient entry : response.getPatient()) {
//			ObjectMapper mapper = new ObjectMapper();
////			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
////			Patient patient = mapper.convertValue(entry.getResource(), Patient.class);
//			patientList.add(patient);
//		}
		return patientList;
	}
	
	private String buildURIPatientList() {
		StringBuffer uri = new StringBuffer("http://test.fhir.org/r4");
		uri.append("/Patient/41225");
		uri.append("?_format=json&_pretty=true");
		
		UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(uri.toString());
		
		log.info("Builded URI: {} ", builder.build().toUri());
		
		return builder.toUriString();
	}
	
	

}
