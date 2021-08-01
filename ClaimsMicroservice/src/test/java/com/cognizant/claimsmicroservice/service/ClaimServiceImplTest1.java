package com.cognizant.claimsmicroservice.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.claimsmicroservice.client.PolicyClient;
import com.cognizant.claimsmicroservice.dto.ClaimStatusDTO;
import com.cognizant.claimsmicroservice.exception.ProviderNotFoundException;
import com.cognizant.claimsmicroservice.model.Benefits;
import com.cognizant.claimsmicroservice.model.Claim;
import com.cognizant.claimsmicroservice.model.ProviderPolicy;
import com.cognizant.claimsmicroservice.repository.ClaimRepository;

import lombok.extern.slf4j.Slf4j;

/*
 * 
 *
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class ClaimServiceImplTest1 {

	@InjectMocks
	private ClaimServiceImpl claimServiceImpl;

	@Mock
	private ClaimRepository claimRepoMock;

	@Mock
	private PolicyClient policyClient;

	@Mock
	private ClaimStatusDTO claimDto;

	@Mock
	private Claim claim;

	private List<ProviderPolicy> providers;

	private List<Benefits> benefits;

	@BeforeEach
	void setUp() throws Exception {
		claim = new Claim();
		claim.setClaimId(2);
		claim.setClaimStatus("Pending Action");
		claim.setDescription("claim has been submitted! Please check after few days for confirmation");
		claim.setPolicyId(1);
		claim.setBenefitId(202);
		claim.setMemberId(1);
		claim.setProviderId(1);
		claim.setAmountClaimed(60000.0);
		claim.setAmountSettled(60000.0);

		//claimDto = new ClaimStatusDTO();
		claimDto.setClaimStatus("Pending Action");
		claimDto.setDescription("claim has been submitted! Please check after few days for confirmation");
	}

	@Test
	void claimServiceImplNotNullTest() {
		assertNotNull(claimServiceImpl);
	}

	/*
	 * @Test void testGetClaimStatus_positive() throws ProviderNotFoundException {
	 * 
	 * when(claimRepoMock.getById(2)).thenReturn(claim);
	 * 
	 * 
	 * 
	 * log.debug("impl={}",claimServiceImpl.getClaimStatus(2, 1, 1));
	 * 
	 * assertEquals(claimRepoMock.getById(2).getClaimStatus(),
	 * claimServiceImpl.getClaimStatus(2, 1, 1).getClaimStatus());
	 * 
	 * 
	 * }
	 */

	@Test
	void testGetClaimStatus_negative() throws ProviderNotFoundException {
		when(claimRepoMock.getById(2)).thenReturn(claim);
		ProviderNotFoundException thrown = Assertions.assertThrows(ProviderNotFoundException.class,
				() -> claimServiceImpl.getClaimStatus(2, 1, 3));

		assertEquals("provider not found", thrown.getMessage());

	}

	/*
	 * @Test void testSubmitClaimStatus_negative() {
	 * 
	 * when(claimRepoMock.getById(2)).thenReturn(claim); log.debug("claim test={}",
	 * claim); log.debug("claimdto Test={}", claimDto.getClaimStatus()); //
	 * claim=claimRepoMock.getById(2); // claimDto.setClaimStatus("Pending Action");
	 * // claimDto.setDescription("claim has been submitted! Please check after few
	 * // days for confirmation"); // claimDto = claimServiceImpl.getClaimStatus(2,
	 * 1, 1);
	 * 
	 * ProviderNotFoundException thrown =
	 * Assertions.assertThrows(ProviderNotFoundException.class, () ->
	 * claimServiceImpl.processSubmitClaim(1, 2, 3, 7, 202, 60000.0, 60000.0,
	 * "token"));
	 * 
	 * //BenefitsNotFoundException thrown2 =
	 * Assertions.assertThrows(BenefitsNotFoundException.class, // () ->
	 * claimServiceImpl.processSubmitClaim(1, 2, 1, 1, 202, 60000.0, 60000.0,
	 * "token"));
	 * 
	 * //log.debug("claimdto={}", claimDto.getClaimStatus());
	 * 
	 * // assertEquals(claimRepoMock.getById(2).getClaimStatus(), //
	 * claimDto.getClaimStatus());
	 * 
	 * //assertEquals("provider not found", thrown.getMessage());
	 * //assertEquals("benefit not found", thrown2.getMessage());
	 * //when(claimRepoMock.save(claim)).thenReturn(claim);
	 * //when(claimRepoMock.getById(2)).thenReturn(claim);
	 * 
	 * //
	 * when(policyClient.getChainOfProviders(1,"dummy-token")).thenReturn(providers)
	 * ; //ResponseEntity<Double>eligibleClaimAmount = new
	 * ResponseEntity<Double>(10000.0, HttpStatus.OK); //
	 * when(policyClient.getClaimAmount(1, 1, 202,
	 * "dummy-token")).thenReturn(10000.0); //ResponseEntity<?> brs =
	 * newResponseEntity<>(benefits,HttpStatus.OK);
	 * when(policyClient.getEligibleBenefits(1,
	 * 1,"dummy-token")).thenReturn(benefits);
	 * 
	 * //when(claimServiceImpl.processSubmitClaim(1, 2, 1, 1, 202,
	 * 60000.0,60000.0,"dummy-token")) // .thenReturn(claimDto); } }
	 */

}
