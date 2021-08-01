package com.cognizant.claimsmicroservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.claimsmicroservice.model.Benefits;
import com.cognizant.claimsmicroservice.model.ProviderPolicy;

/*Proxy for policy microservice 
 *4 end points
*/
@FeignClient(name = "policy-microservice", url = "http://localhost:8010/policy")
public interface PolicyClient {

	@RequestMapping(value = "/saveProvider", method = RequestMethod.POST)
	public ProviderPolicy setProviderPolicy(@RequestBody ProviderPolicy provider);

	@RequestMapping(value = "getChainOfProviders/{policyId}", method = RequestMethod.GET)
	public List<ProviderPolicy> getChainOfProviders(@PathVariable("policyId") int policyId,
			@RequestHeader(value = "Authorization", required = false) String token);

	@RequestMapping(value = "getEligibleBenefits/{policyId}/{memberId}", method = RequestMethod.GET)
	public List<Benefits> getEligibleBenefits(@PathVariable("policyId") int policyId,
			@PathVariable("memberId") int memberId,
			@RequestHeader(value = "Authorization", required = false) String token);

	@GetMapping("/getClaimAmount/{policyId}/{memberId}/{benefitId}")
	public double getClaimAmount(@PathVariable int policyId, @PathVariable int memberId,
			@PathVariable int benefitId, @RequestHeader(value = "Authorization", required = false) String token);

}
