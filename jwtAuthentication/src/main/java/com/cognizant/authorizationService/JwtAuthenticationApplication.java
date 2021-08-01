package com.cognizant.authorizationService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.authorizationService.Repository.UserRepository;
import com.cognizant.authorizationService.model.MyUser; 

/**
 * 
 * POD 6 -Claims Management System , This is the application class for
 * JwtAuthentication Microservice
 * 
 */
@SpringBootApplication
public class JwtAuthenticationApplication {
	

	@Autowired
    private UserRepository repository;
	
	/**
	 * 
	 * Command Line Runner for the registered user's
	 * 
	 * 
	 */
	
    @PostConstruct
    public void initUsers() {
        List<MyUser> users = Stream.of(
               new MyUser("1","Vaibhav","Vaibhav"),
               new MyUser("2","Abhishek","Abhishek"),
               new MyUser("3","admin","admin")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }
    
    /**
	 * Main Method- SpringBoot main method to launch an application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(JwtAuthenticationApplication.class, args);
		
	}

}
