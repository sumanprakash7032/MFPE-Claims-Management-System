package com.cognizant.membermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * POD 6 -Claims Management System This is Application class for Spring boot
 *
 */

@SpringBootApplication
@EnableFeignClients
public class MemberMicroserviceApplication {

	/**
	 * main Method- SpringBoot main method to launch an application.
	 */

	public static void main(String[] args) {
		SpringApplication.run(MemberMicroserviceApplication.class, args);
	}

}
