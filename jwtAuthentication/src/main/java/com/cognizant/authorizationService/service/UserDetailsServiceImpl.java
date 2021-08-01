package com.cognizant.authorizationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.authorizationService.Repository.UserRepository;
import com.cognizant.authorizationService.model.MyUser;

/**
 * This class validate username and returns the username and password
 */ 

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	 /**
	 * @param username
	 * validate the username
	 * after successful validation
	 * Returns username and password
	 * If not valid then throws UsernameNotFoundException 
	 */ 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser myUser =  userRepository.findByUsername(username);
		return new User(myUser.getUsername(),myUser.getPassword(),new ArrayList<>());
	}


}
