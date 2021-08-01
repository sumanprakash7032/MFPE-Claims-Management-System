package com.cognizant.authorizationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.authorizationService.model.MyUser;

/**
 * This is the user repository to fetch the username
 */ 
public interface UserRepository extends JpaRepository<MyUser,String > {
	
	/**
	 * @param username
	 * returns username by username from database
	 */ 
	public MyUser findByUsername(String username);

	

}
