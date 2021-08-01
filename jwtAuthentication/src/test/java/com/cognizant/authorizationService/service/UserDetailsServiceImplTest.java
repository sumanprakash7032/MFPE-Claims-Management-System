package com.cognizant.authorizationService.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.authorizationService.Repository.UserRepository;
import com.cognizant.authorizationService.model.MyUser;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDetailsServiceImplTest {
	
	@InjectMocks
	UserDetailsServiceImpl userDetailsServiceImpl;
	@Mock
	UserRepository userRepository;
	@Mock
	UserDetails userDetails;

	@Test
	public void loadUserByUsername() {
	MyUser myUser=new MyUser(1,"admin","admin");
	when(userRepository.findByUsername("admin")).thenReturn(myUser);
	UserDetails loadUserByUsername = userDetailsServiceImpl.loadUserByUsername("admin");
	assertEquals(loadUserByUsername.getUsername(),myUser.getUsername());
	}
}
