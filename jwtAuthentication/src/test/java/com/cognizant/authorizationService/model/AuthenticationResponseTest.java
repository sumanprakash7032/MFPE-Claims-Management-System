package com.cognizant.authorizationService.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthenticationResponseTest {

	@Mock
	public AuthenticationResponse authenticationResponse;

	
	
	@Test
	public void AllArgConstTest() {
		AuthenticationResponse auth = new AuthenticationResponse("Token", true);
		assertEquals(authenticationResponse.getValid(), auth.getValid());
		assertEquals(authenticationResponse.getJwtToken(),auth.getJwtToken());

	}
	
	@Test
	public void testNoArgsConstructor() {
		
		authenticationResponse = new AuthenticationResponse();
		assertEquals(authenticationResponse, authenticationResponse);
	}
	
	@Test
	public void testEqualsMethod() {
		boolean equals = authenticationResponse.equals(authenticationResponse);
		assertTrue(equals);
	}
	
	@Test
	public void testHashCodeMethod() {
		int hashCode = authenticationResponse.hashCode();
		assertEquals(hashCode,authenticationResponse.hashCode());
	}
	
	@BeforeEach
	void setUp() {
		authenticationResponse = new AuthenticationResponse();
		authenticationResponse.setJwtToken("Token");
		authenticationResponse.setValid(true);
	}
	
}
