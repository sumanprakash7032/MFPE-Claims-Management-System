package com.cognizant.authorizationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.authorizationService.model.AuthenticationResponse;

/**
 * This class validate the service and return authentication response
 */ 
@Service
public class ValidateService {
	@Autowired
	private JwtUtilService jwtutilService;
	
	 /**
	 * @param token
	 * compare the token
	 * returns the authenticationResponse
	 */ 
	public AuthenticationResponse validate(String token) {
		var authenticationResponse = new AuthenticationResponse();
		var jwt = token.substring(7);
		authenticationResponse.setJwtToken(jwt);
		authenticationResponse.setValid(jwtutilService.validateToken(jwt));
		return authenticationResponse;
	}
}
