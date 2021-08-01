//package com.cognizant.authorizationService.util;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.cognizant.authorizationService.Repository.UserRepository;
//import com.cognizant.authorizationService.model.AuthenticationResponse;
//import com.cognizant.authorizationService.model.MyUser;
//import com.cognizant.authorizationService.service.MyUserDetailsService;
//
//public class MyUserDetailsServiceTest {
//	
//	AuthenticationResponse response;
//	
//	private MyUserDetailsService myUserDetailsService;
//	
//	private UserRepository userRepository;
//	
//	private UserDetails userDetails;
//	
////	@Test
////	public void loadUserByUsername() {
////		AuthenticationResponse auth=new AuthenticationResponse("Token",true);
////		assertEquals(auth.getJwtToken(),response.getJwtToken());
////		assertEquals(auth.getValid(),response.getValid());
////		
////	}
//	
//	@BeforeEach
//	void setUp() {
//		MyUser myUser=new MyUser("1","abhi","abhi");
//		myUser.setMemberid("1");
//		myUser.setUsername("abhi");
//		myUser.setPassword("abhi");
//	}
//	
//	@Test
//	public void loadUserByUsername() {
//	MyUserDetailsService myUserDetailsService=new MyUserDetailsService();
//	UserRepository userRepository=mock (UserRepository.class);
//	when(myUserDetailsService.loadUserByUsername("abhi")).thenReturn(userDetails);
//	
//	
//	assertEquals(userRepository.findByUsername("abhi"),userDetails.getUsername());
//	}
//}
