package com.cognizant.membermicroservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.membermicroservice.client.AuthClient;

/**
 * 
 * This class contains test cases for the AuthenticationResponse model class
 * which are written using junit
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthenticationResponseTest {

	@Mock
	public AuthenticationResponse response;

	@Mock
	private AuthClient authClient;

	/**
	 * 
	 * Testing the allargsConstructor
	 */

	@Test
	public void AllArgConstTest() {
		AuthenticationResponse auth = new AuthenticationResponse("Token", true);
		assertEquals(response.getValid(), auth.getValid());
		assertEquals(response.getJwtToken(), auth.getJwtToken());

	}

	/**
	 * 
	 * Testing the noargsConstructor
	 */

	@Test
	public void testNoArgsConstructor() {

		AuthenticationResponse response = new AuthenticationResponse();
		assertEquals(response, response);
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = response.equals(response);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		int hashCode = response.hashCode();
		assertEquals(hashCode, response.hashCode());
	}

	@BeforeEach
	void setUp() {
		response = new AuthenticationResponse();
		response.setJwtToken("Token");
		response.setValid(true);
	}

}
