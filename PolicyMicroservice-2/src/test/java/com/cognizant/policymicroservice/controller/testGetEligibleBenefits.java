
package com.cognizant.policymicroservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

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
import com.cognizant.policymicroservice.model.Benefits;
import com.cognizant.policymicroservice.model.MemberPolicy;
import com.cognizant.policymicroservice.repository.MemberPolicyRepo;

/*
 * test case for getEligibleBenefits in policyMicroserviceController class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class testGetEligibleBenefits {
	@InjectMocks
	PolicyMicroserviceContoller controllerMock;

	@Mock
	MemberPolicy memberPolicy;

	@Mock
	AuthClient authClient;

	@Mock
	List<Benefits> benefitDetails;

	@Mock
	private MemberPolicyRepo memberRepoMock;
	@Mock
	private AuthClient authClientMock;

	/*
	 * test the getEligibleBenefits method
	 */
	@Test
	void GetEligibleBenefits_test() {
		AuthenticationResponse response = new AuthenticationResponse("token", true);
		ResponseEntity<MemberPolicy> benefits = new ResponseEntity<MemberPolicy>(memberPolicy, HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(response);
		assertEquals(benefits.getStatusCodeValue(),
				controllerMock.getEligibleBenefits(1, 1, "token").getStatusCodeValue());
	}

}
