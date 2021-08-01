package com.cognizant.claimsmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.claimsmicroservice.client.AuthClient;
import com.cognizant.claimsmicroservice.dto.ClaimStatusDTO;
import com.cognizant.claimsmicroservice.exception.BenefitsNotFoundException;
import com.cognizant.claimsmicroservice.exception.ProviderNotFoundException;
import com.cognizant.claimsmicroservice.service.ClaimService;

import feign.FeignException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/*
 * operations related to submitting claim and getting the claim status
 * 
 */
@Slf4j
@Api(value = "Claims Controller")
@CrossOrigin(origins = "*")
@RestController
public class ClaimsController {

	@Autowired
	ClaimService claimserviceImpl;

	@Autowired
	AuthClient authClient;

	@Autowired
	ClaimStatusDTO claimsStatusDto;

	/*
	 * this method invokes authorizationMicroservice to check the validity of token first 
	 * then invokes the claimServiceImpl which invokes the claimRepository and get status of the claim
	 * 
	 * @param claimId-claim id
	 * @param policyId- id of the policy subscribed by the member
	 * @param memberId- member id of the user
	 * @requestHeader token- token passed from member microservice
	 * 
	 * @return ResponseEntity of ClaimStatusDTO type 
	 * Or 
	 * @return if token is invalid return responseEntityof type String(message) and status forbidden
	 */
	@ApiOperation(value = "Get Claim Status")
	@GetMapping(value = "/getClaimStatus/{claimId}/{policyId}/{memberId}", produces = "application/json")
	public ResponseEntity<?> getClaimStatus(@PathVariable int claimId, @PathVariable int policyId,
			@PathVariable int memberId, @RequestHeader(value = "Authorization", required = false) String token) throws ProviderNotFoundException {
		log.debug("token={}",token);
	
			if (!authClient.getValidity(token).getValid()) {

				return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
			}

		return new ResponseEntity<ClaimStatusDTO>(claimserviceImpl.getClaimStatus(claimId, policyId, memberId),
				HttpStatus.OK);
	}
	
	/*
	 * this method invokes authorizationMicroservice to check the validity of token first 
	 * then invokes the claimServiceImpl which invokes policyMicroservice 
	 * to get List of provider , benefits and get the claim amount.
	 * 
	 * @param claimId-claim id
	 * @param policyId- id of the policy subscribed by the member
	 * @param memberId- member id of the user
	 * @param providerId- provider id of a provider
	 * @param benefitId- benefit id which user is availing claim for
	 * @param totalAmount-total amount given in the health-care bill
	 * @param claimAmount- the amount which user wants to claim
	 * 
	 * @return  ResponseEntity of type ClaimStatusDTO(claim status and its description)
	 * or if token is not valid
	 * @return  ResponseEntity of type String(message) and status forbidden
	 */
	@ApiOperation(value = "Submit Claim")
	@PostMapping(value = "/submitClaim/{policyId}/{claimId}/{memberId}/{providerId}/{benefitId}/{totalAmount}/{claimedAmount}", produces = "application/json")
	public ResponseEntity<?> submitClaim(@PathVariable int policyId, @PathVariable int claimId,
			@PathVariable int memberId, @PathVariable int providerId, @PathVariable int benefitId,
			@PathVariable double totalAmount, @PathVariable double claimedAmount,
			@RequestHeader(value = "Authorization", required = false) String token) throws ProviderNotFoundException, BenefitsNotFoundException {
		try {
			if (!authClient.getValidity(token).getValid()) {

				return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
			}
		}catch (FeignException e) {
			return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.BAD_REQUEST);

		}

			claimsStatusDto = claimserviceImpl.processSubmitClaim(policyId, claimId, memberId, providerId, benefitId, totalAmount,
					claimedAmount,token);

		log.debug("claimsDTO={}", claimsStatusDto);
		return new ResponseEntity<ClaimStatusDTO>(claimsStatusDto, HttpStatus.OK);
	}

}
