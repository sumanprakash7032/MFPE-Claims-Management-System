package com.cognizant.authorizationService.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.authorizationService.service.JwtUtilService;



@SpringBootTest(classes = JwtUtilService.class)
@RunWith(SpringRunner.class)
class JwtUtilServiceTest {
	
	UserDetails userDetails;
	
	@InjectMocks
	JwtUtilService jwtUtilService;
	
	@Test
	void genrateTokenTest() {
		userDetails = new User("advsdvdmin","advsdvdmin", new ArrayList<>());
		String generateToken = jwtUtilService.generateToken(userDetails);
		assertNotNull(generateToken);
	}
	
	@Test
	void validateTokenTest() {
		userDetails = new User("dvsdvmin","adcadcmin", new ArrayList<>());
		String generateToken = jwtUtilService.generateToken(userDetails);
		Boolean validateToken = jwtUtilService.validateToken(generateToken);
		assertEquals(true, validateToken);
	}
	
	
	
}
