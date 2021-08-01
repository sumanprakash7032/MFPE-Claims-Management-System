package com.cognizant.authorizationService.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.authorizationService.exception.BadCredentialException;
import com.cognizant.authorizationService.exception.LoginException;
import com.cognizant.authorizationService.model.AuthenticationRequest;
import com.cognizant.authorizationService.service.JwtUtilService;
import com.cognizant.authorizationService.service.UserDetailsServiceImpl;
import com.cognizant.authorizationService.service.ValidateService;

@SpringBootTest
@RunWith(SpringRunner.class)
class AuthenticationControllerTest {
	@Mock
	private AuthenticationManager authenticationManager;

	@Mock
	private JwtUtilService jwtTokenUtil;

	@Mock
	private UserDetailsServiceImpl userDetailsService;

	@Mock
	private ValidateService validateService;
	@InjectMocks
	private AuthenticationController authenticationController;

	@Test
	void testValidLogin() throws BadCredentialException, LoginException  {
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("admin1", "admin1");
		UserDetails userDetails = new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(),
				new ArrayList<>());

		when(userDetailsService.loadUserByUsername("admin1")).thenReturn(userDetails);
		when(jwtTokenUtil.generateToken(userDetails)).thenReturn("dummy-token");

		ResponseEntity<?> authenticationResponse = authenticationController.createAuthenticationToken(authenticationRequest);
		assertEquals(HttpStatus.OK, authenticationResponse.getStatusCode());
	}

	@Test
	void testInvalidLogin() throws BadCredentialException, LoginException {
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("admin1", "suman1");
		UserDetails userDetails = new User(authenticationRequest.getUsername(),"admin1", new ArrayList<>());
		when(userDetailsService.loadUserByUsername("admin1")).thenReturn(userDetails);
		/* when(jwtTokenUtil.generateToken(userDetails)).thenReturn("dummy-token"); */
		Exception thrown = Assertions.assertThrows(LoginException.class,
				() ->authenticationController.createAuthenticationToken(authenticationRequest));
		assertEquals("Invalid Username or Password", thrown.getMessage());
		
	}
	
	@Test
	void testValidToken() throws BadCredentialException, LoginException {
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("admin1", "admin1");
		UserDetails userDetails = new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(),
				new ArrayList<>());
		when(jwtTokenUtil.generateToken(userDetails)).thenReturn("token");
		when(jwtTokenUtil.validateToken("token")).thenReturn(true);
		when(jwtTokenUtil.extractUsername("token")).thenReturn("admin1");
		when(userDetailsService.loadUserByUsername("admin1")).thenReturn(userDetails);

		ResponseEntity<?> validity = authenticationController.createAuthenticationToken(authenticationRequest);
		assertEquals(HttpStatus.OK,validity.getStatusCode());
	}

	@Test
	void testInvalidToken() throws BadCredentialException, LoginException {
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("suman1", "suman1");
		UserDetails userDetails = new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(),
				new ArrayList<>());
		when(jwtTokenUtil.generateToken(userDetails)).thenReturn("token");
		when(jwtTokenUtil.validateToken("mhgvuygy")).thenReturn(false);
		when(jwtTokenUtil.extractUsername("token")).thenReturn("suman1");
		when(userDetailsService.loadUserByUsername("suman1")).thenReturn(userDetails);

		ResponseEntity<?> validity = authenticationController.createAuthenticationToken(authenticationRequest);
		assertEquals(false, validity.getBody().toString().contains("false"));
	}
}