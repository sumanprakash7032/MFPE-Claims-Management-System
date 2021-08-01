package com.cognizant.claimsmicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import com.cognizant.claimsmicroservice.model.AuthenticationResponse;

@FeignClient(name = "authenticationFeignClient",url = "${AUTH_SERVICE:http://localhost:8089}")
public interface AuthClient {

	@GetMapping("/authorization/validate") 
	  public AuthenticationResponse getValidity(@RequestHeader(name="Authorization") final String token);
}