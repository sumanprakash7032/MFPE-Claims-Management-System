package com.cognizant.authorizationService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * This is the model class for AuthenticationRequest
 */ 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {

	private String username;
	private String password;

}
