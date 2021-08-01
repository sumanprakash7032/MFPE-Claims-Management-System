package com.cognizant.authorizationService.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BadCredentialExceptionTest {

	@Mock
	private BadCredentialException badCredentialException;
	
	@Test
	public void testOneArgConstructor() {
		badCredentialException = new BadCredentialException("File Not Found.");
		assertEquals("File Not Found.", badCredentialException.getMessage());
	}
	
	
}
