//package com.cognizant.authorizationService.util;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.cognizant.authorizationService.model.AuthenticationResponse;
//import com.cognizant.authorizationService.service.ValidateService;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class ValidateServiceTest {
//
//	private AuthenticationResponse response;
//	
//	private ValidateService validateService;
//	
//	@Test
//	public void validateTest() {
//		AuthenticationResponse response =new AuthenticationResponse("Token",true);
//		when(validateService.validate("token")).thenReturn(response);
//		assertEquals(response.getJwtToken(),validateService.validate("token"));
//	}
//}
