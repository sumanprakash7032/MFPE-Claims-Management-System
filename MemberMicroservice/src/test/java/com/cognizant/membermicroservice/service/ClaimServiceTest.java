package com.cognizant.membermicroservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

/**
 * this is the interface where the service methods are declared
 */

public class ClaimServiceTest {

	@Mock
	ClaimService service;

	/**
	 * test to check the method is null
	 */

	@Test
	@DisplayName("Checking for ClaimService - if it is loading or not for @GetMapping")
	void repairServiceImplNullTest() {
		assertThat(service).isNull();
	}
}
