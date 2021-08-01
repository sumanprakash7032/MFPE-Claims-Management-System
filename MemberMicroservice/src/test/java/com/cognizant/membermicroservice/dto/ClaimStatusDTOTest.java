package com.cognizant.membermicroservice.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * This class contains test cases for the ClaimStatusDTO class which are written
 * using junit
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClaimStatusDTOTest {

	@Mock
	private ClaimStatusDTO csd;

	/**
	 * Test the ClaimStatusDTO is not null
	 */

	@Test
	@DisplayName("Checking if ClaimStatusDTO class is loading or not.")
	void claimStatusDTOIsLoadedOrNot() {
		assertThat(csd).isNotNull();
	}

	/**
	 * Test the ClaimStatusDTO constructor
	 */

	@DisplayName("Checking if ClaimStatusDTO class is responding correctly or not.")
	@Test
	void testingMember() {

		csd = new ClaimStatusDTO("Not Claimed", "Medibuddy Claim");
		csd.setClaimStatus("Claimed");
		csd.setDescription("LIC Claim");

		assertEquals("Claimed", csd.getClaimStatus());
		assertEquals("LIC Claim", csd.getDescription());

	}
}
