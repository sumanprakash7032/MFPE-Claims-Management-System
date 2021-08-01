package com.cognizant.policymicroservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.policymicroservice.client.AuthClient;

/*
 * Test Cases for AuthenticationResponse
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class AuthenticationResponseTest {

	@Mock
	public AuthenticationResponse response;

	@Mock
	private AuthClient authClient;

	/* 
	 * Testing the allargsConstructor
	 */

	@Test
	public void AllArgConstTest() {
		AuthenticationResponse auth = new AuthenticationResponse("Token", true);
		assertEquals(response.getValid(), auth.getValid());
		assertEquals(response.getJwtToken(), auth.getJwtToken());

	}

	/*
	 * Testing the noargsConstructor
	 */

	@Test
	public void testNoArgsConstructor() {

		AuthenticationResponse response = new AuthenticationResponse();
		assertEquals(response, response);
	}

	/*
	 * test the AuthenticationRequest Equals method
	 */
	@Test
	public void testEqualsMethod() {
		boolean equals = response.equals(response);
		assertTrue(equals);
	}

	/*
	 * test the AuthenticationRequest hashCode method
	 */
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
