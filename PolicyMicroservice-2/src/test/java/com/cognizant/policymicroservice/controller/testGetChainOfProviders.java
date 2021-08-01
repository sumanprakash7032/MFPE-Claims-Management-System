package com.cognizant.policymicroservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.policymicroservice.client.AuthClient;
import com.cognizant.policymicroservice.model.AuthenticationResponse;
import com.cognizant.policymicroservice.model.ProviderPolicy;
import com.cognizant.policymicroservice.repository.ProviderPolicyRepo;

/*
 * test case for getChainOfProviders in policyMicroserviceController class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class testGetChainOfProviders {

	@InjectMocks
	private PolicyMicroserviceContoller controllerMock;

	@Mock
	private ProviderPolicy providerPolicy;

	@Mock
	private ProviderPolicyRepo providerRepo;

	@Mock
	private AuthClient authClient;

	/*
	 * test getChainOfProviders is working or not
	 */
	@Test
	public void getChainOfProvidersTest() {

		AuthenticationResponse response = new AuthenticationResponse("token", true);
		ResponseEntity<ProviderPolicy> providers = new ResponseEntity<ProviderPolicy>(providerPolicy, HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(response);
		assertEquals(providers.getStatusCodeValue(),
				controllerMock.getChainOfProviders(1, "token").getStatusCodeValue());
	}
}