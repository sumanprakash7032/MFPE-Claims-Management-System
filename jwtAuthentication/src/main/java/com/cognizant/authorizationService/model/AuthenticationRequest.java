package com.cognizant.authorizationService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * This is the model class for AuthenticationRequest
 */ 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {

	private String username;
	private String password;

}
