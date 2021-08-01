package com.cognizant.claimsmicroservice.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant.claimsmicroservice.dto.ClaimStatusDTO;
import com.cognizant.claimsmicroservice.exception.BenefitsNotFoundException;
import com.cognizant.claimsmicroservice.exception.ProviderNotFoundException;
//Interface for the service
@Service
@Component
public interface ClaimService {

	public ClaimStatusDTO getClaimStatus(int claimId,int policyId, int memberId) throws ProviderNotFoundException;
	
	public ClaimStatusDTO processSubmitClaim(int policyId,
			 int claimId,
			 int memberId,
			 int providerId,
			 int benefitId,
			 double totalAmount,
			 double claimedAmount,String token)throws ProviderNotFoundException,BenefitsNotFoundException;
	
}
