package com.cognizant.policymicroservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.policymicroservice.client.AuthClient;
import com.cognizant.policymicroservice.model.Benefits;
import com.cognizant.policymicroservice.model.MemberPolicy;
import com.cognizant.policymicroservice.model.ProviderPolicy;
import com.cognizant.policymicroservice.repository.BenefitRepo;
import com.cognizant.policymicroservice.repository.MemberPolicyRepo;
import com.cognizant.policymicroservice.repository.ProviderPolicyRepo;

import feign.FeignException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*
 * This class contains operations for getting the claim providers,eligible benefits,eligible claim amount
 */
@RestController
@Api(value = "policy Microservice Controller", description = "operations related to getting the providers for the claim, getting eligible benfits and also getting the eligible claim Amount")
@CrossOrigin(origins = "http://localhost:4200")
public class PolicyMicroserviceContoller {

	@Autowired
	ProviderPolicyRepo providerRepo;

	@Autowired
	MemberPolicyRepo memberPolicyRepo;

	@Autowired
	BenefitRepo benefitRepo;

	@Autowired
	AuthClient authClient;

	/*
	 * This method is used to add new provider
	 * 
	 * the details of the provider is saved into ProviderPolicy Repository
	 */
	@ApiOperation(value = "Add new providers")
	@RequestMapping(value = "/saveProvider", method = RequestMethod.POST)
	public ProviderPolicy setProviderPolicy(@RequestBody ProviderPolicy provider) {

		return providerRepo.save(provider);
	}

	/*
	 * 
	 * This method invokes authorizationMicroservice to validate the token
	 * 
	 * if token is valid then returns the list of providers which accepts the claim
	 * for particular policy
	 * 
	 * if token is invalid then returns responseEntity of tyep String(message) and
	 * status as forbidden
	 */
	@ApiOperation(value = "List of providers which accepts the claim for particular policy")
	@RequestMapping(value = "getChainOfProviders/{policyId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getChainOfProviders(@PathVariable("policyId") int policyId,
			@RequestHeader(value = "Authorization", required = false) String token) {
		try {
			if (!authClient.getValidity(token).getValid()) {

				return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
			}

		} catch (FeignException e) {
			return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);

		}
		List<ProviderPolicy> providers = providerRepo.findAllByPolicyIdOrderByLocation(policyId);
		/*
		 * List<String> providerDetails = new ArrayList<String>(); String details =
		 * null; for (ProviderPolicy provider : providers) { details =
		 * provider.getProviderId() + "   " + provider.getProviderName() + "   " +
		 * provider.getProviderAddress() + "   " + provider.getLocation();
		 * providerDetails.add(details); }
		 */
		return new ResponseEntity<>(providers, HttpStatus.OK);
	}

	/*
	 * 
	 * This method invokes authorizationMicroservice to validate the token
	 * 
	 * if token is valid then returns the list of providers which are under a
	 * particular policy
	 * 
	 * if token is invalid then returns responseEntity of tyep String(message) and
	 * status as forbidden
	 */
	@ApiOperation(value = "List of benefits which can be aviled under a particular policy")
	@RequestMapping(value = "getEligibleBenefits/{policyId}/{memberId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getEligibleBenefits(@PathVariable("policyId") int policyId,
			@PathVariable("memberId") int memberId,
			@RequestHeader(value = "Authorization", required = false) String token) {

		try {
			if (!authClient.getValidity(token).getValid()) {

				return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
			}

		} catch (FeignException e) {
			return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);

		}
		List<MemberPolicy> providers = memberPolicyRepo.findAllByPolicyIdAndMemberId(policyId, memberId);

		List<Benefits> benefitDetails = new ArrayList<Benefits>();
		for (MemberPolicy memberPolicy : providers) {
			int benefitId = memberPolicy.getBenefitId();
			benefitDetails.add(getBenefitId(benefitId));

		}
		return new ResponseEntity<>(benefitDetails, HttpStatus.OK);

	}

	/*
	 * This method is used to return the benefits
	 * 
	 * benefitId is taken as input and output is retrieved from benefit repository
	 */
	public Benefits getBenefitId(int benefitId) {
		return benefitRepo.findByBenefitId(benefitId);
	}

	/*
	 * 
	 * This method invokes authorizationMicroservice to validate the token
	 * 
	 * if token is valid then returns the amount that a particular member can claim
	 * 
	 * if token is invalid then returns responseEntity of type String(message) and
	 * status as forbidden
	 */
	@ApiOperation(value = "Eligible claim amount that a member can claim")
	@GetMapping(value = "/getClaimAmount/{policyId}/{memberId}/{benefitId}", produces = "application/json")
	public ResponseEntity<?> getEligibleClaimAmount(@PathVariable int policyId, @PathVariable int memberId,
			@PathVariable int benefitId, @RequestHeader(value = "Authorization", required = false) String token) {
		try {
			if (!authClient.getValidity(token).getValid()) {

				return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
			}

		} catch (FeignException e) {
			return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);

		}
		MemberPolicy mempolicy = memberPolicyRepo.findCapAmount(policyId, memberId, benefitId);

		return new ResponseEntity<Double>(mempolicy.getCapAmountBenefits(), HttpStatus.OK);
	}

}
