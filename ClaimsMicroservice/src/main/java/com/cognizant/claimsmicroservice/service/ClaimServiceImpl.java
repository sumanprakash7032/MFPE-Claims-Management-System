package com.cognizant.claimsmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.claimsmicroservice.client.PolicyClient;
import com.cognizant.claimsmicroservice.dto.ClaimStatusDTO;
import com.cognizant.claimsmicroservice.exception.BenefitsNotFoundException;
import com.cognizant.claimsmicroservice.exception.ProviderNotFoundException;
import com.cognizant.claimsmicroservice.model.Benefits;
import com.cognizant.claimsmicroservice.model.Claim;
import com.cognizant.claimsmicroservice.model.ProviderPolicy;
import com.cognizant.claimsmicroservice.repository.ClaimRepository;

import lombok.extern.slf4j.Slf4j;


/*
 * contains method for submitting the claim status and getting the claim status
 * 
 * 
 */
@Slf4j
@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	ClaimRepository claimRepository;

	@Autowired
	ClaimStatusDTO claimStatusDTO;

	@Autowired
	PolicyClient policyClient;

	/*
	 * returns status of the claim which are already submitted
	 * 
	 * @param claimId-claim id
	 * 
	 * @param policyId- id of the policy subscribed by the member
	 * 
	 * @param memberId- member id of the user
	 * 
	 * @return claim status and its description
	 * 
	 * 
	 */
	@Override
	public ClaimStatusDTO getClaimStatus(int claimId, int policyId, int memberId) throws ProviderNotFoundException {
		
		Claim claim = claimRepository.getById(claimId);
		

		log.debug("claim status={}", claim.getClaimStatus());
		log.debug("Policy={}", claim.getPolicyId());
		log.debug("claimid={}", claim.getClaimId());
		log.debug("member={}", claim.getMemberId());
		
		if (claim.getPolicyId() == policyId && claim.getMemberId() == memberId) {
			claimStatusDTO.setClaimStatus(claim.getClaimStatus());
			claimStatusDTO.setDescription(claim.getDescription());
			log.debug("claimdto={}", claimStatusDTO.getClaimStatus());
		}
		else {
			throw new ProviderNotFoundException("provider not found");
		}
		
		return claimStatusDTO;
	
	}

	/*
	 * submit the new claim if 3 conditions are true: 1. If the Claimed Amount is
	 * applicable under the subscribed policy 2. If the Claimed benefit is
	 * applicable under the subscribed policy 3. If the Hospital in which benefits
	 * are availed is a permissible Health Care Provider (Hospital).
	 * 
	 * Claims Microservice will invoke the Policy Microservice for retrieving the
	 * permissible Provider Details (Hospital), eligible benefits of a policy and
	 * the eligible claim amount for the benefits. Based on the details retrieved,
	 * the Claims Microservice will decide on any of the following actions:
	 * sanctioning / rejecting / raising a dispute
	 * 
	 * 
	 * 
	 * @param claimId-claim id
	 * 
	 * @param policyId- id of the policy subscribed by the member
	 * 
	 * @param memberId- member id of the user
	 * 
	 * @param providerId- provider id of a provider
	 * 
	 * @param benefitId- benefit id which user is availing claim for
	 * 
	 * @param totalAmount-total amount given in the health-care bill
	 * 
	 * @param claimAmount- the amount which user wants to claim
	 * 
	 * @return claim status and its description
	 * 
	 * 
	 */
	@Override
	public ClaimStatusDTO processSubmitClaim(int policyId, int claimId, int memberId, int providerId, int benefitId,
			double totalAmount, double claimedAmount, String token) throws ProviderNotFoundException, BenefitsNotFoundException {
		Claim claimObj = null;
		 List<ProviderPolicy> chainOfProviders = policyClient.getChainOfProviders(policyId, token);
		log.debug("chainOfProvider={}", chainOfProviders);
		 List<Benefits> eligibleBenefits = policyClient.getEligibleBenefits(policyId, memberId, token);
		double eligibleClaimAmount = policyClient.getClaimAmount(policyId, memberId, benefitId, token);
		log.debug("claim Amount={}", eligibleClaimAmount);

		if (claimedAmount <= eligibleClaimAmount) {

			if (claimedAmount > totalAmount) {
				claimObj = new Claim(claimId, "Under Dispute",
						"Claim Amount cannot be settled more than its actually required!", policyId, memberId,
						benefitId, providerId, claimedAmount, 0);
				claimRepository.save(claimObj);
				claimStatusDTO.setClaimStatus(claimObj.getClaimStatus());
				claimStatusDTO.setDescription(claimObj.getDescription());
			} else {
				
				ProviderPolicy providers = chainOfProviders.stream().filter(p -> p.getProviderId() == providerId)
						.findFirst().orElseThrow(()->new ProviderNotFoundException("provider not found"));

				Benefits benefits = eligibleBenefits.stream().filter(b -> b.getBenefitId() == benefitId).findFirst()
						.orElseThrow(()->new BenefitsNotFoundException("benefit not found"));
				
				/*if (provider == null || benefit == null) {
					claimDto.setClaimStatus("Insufficient Claim details");
					claimDto.setDescription("particular provider or benefits are not available");
				} else {
					claimObj = new Claim(claimId, "Pending Action",
							"claim has been submitted! Please check after few days for confirmation", policyId,
							memberId, benefitId, providerId, claimedAmount, claimedAmount);*/
				
				claimObj = new Claim(claimId, "Pending Action",
						"claim has been submitted! Please check after few days for confirmation", policyId,
						memberId, benefitId, providerId, claimedAmount, claimedAmount);
				claimRepository.save(claimObj);
				claimStatusDTO.setClaimStatus(claimObj.getClaimStatus());
				claimStatusDTO.setDescription(claimObj.getDescription());

				}
			
		} else {
			claimObj = new Claim(claimId, "Claim Rejected", "Claim Amount is greater than the eligible claim Amount",
					policyId, memberId, benefitId, providerId, claimedAmount, 0);
			claimRepository.save(claimObj);
			claimStatusDTO.setClaimStatus(claimObj.getClaimStatus());
			claimStatusDTO.setDescription(claimObj.getDescription());
		}

		return claimStatusDTO;
	}

}
