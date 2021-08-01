package com.cognizant.authorizationService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is the model class for AuthenticationResponse
 */ 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

	private String jwtToken;
	private Boolean valid;
	
	
	
	
}
