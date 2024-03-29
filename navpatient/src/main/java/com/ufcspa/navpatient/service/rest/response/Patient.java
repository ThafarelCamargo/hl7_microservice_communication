package com.ufcspa.navpatient.service.rest.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fhir.administration.resources.datatypes.Address;
import fhir.administration.resources.datatypes.HumanName;
import fhir.administration.resources.datatypes.Identifier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {
	
	@Builder.Default
	private String resourceType = "Patient";
	 
	private List<Identifier> identifier;
	private boolean active;
	private List<HumanName> name;
	private String birthDate;
	private List<Address> address;

}
