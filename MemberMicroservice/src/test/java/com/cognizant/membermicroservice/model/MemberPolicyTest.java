package com.cognizant.membermicroservice.model;

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
 * This class contains test cases for the MemberPolicy model class which are
 * written using junit
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberPolicyTest {

	@Mock
	private MemberPolicy mempolicy;

	/**
	 * 
	 * Testing MemberPolicy is not null
	 */

	@Test
	@DisplayName("Checking if MemberPolicy class is loading or not.")
	void memberPolicyIsLoadedOrNot() {
		assertThat(mempolicy).isNotNull();
	}

	/**
	 * 
	 * Testing MemberPolicy Constructor
	 */

	@DisplayName("Checking if MemberPolicy class is responding correctly or not.")
	@Test
	void testingMemberPolicy() {
		mempolicy = new MemberPolicy(1, "Abhishek", 3, "2020-07-01", 9, "Amravati", 4, "Medibuddy");
		mempolicy.setMemberId(3);
		mempolicy.setMemberName("Abhi");
		mempolicy.setPolicyId(2);
		mempolicy.setSubscriptionDate("2020-06-26");
		mempolicy.setLocationId(3);
		mempolicy.setLocationName("Pune");
		mempolicy.setProviderId(5);
		mempolicy.setProviderName("HDFC");

		assertEquals(3, mempolicy.getMemberId());
		assertEquals("Abhi", mempolicy.getMemberName());
		assertEquals(2, mempolicy.getPolicyId());
		assertEquals("2020-06-26", mempolicy.getSubscriptionDate());
		assertEquals(3, mempolicy.getLocationId());
		assertEquals("Pune", mempolicy.getLocationName());
		assertEquals(5, mempolicy.getProviderId());
		assertEquals("HDFC", mempolicy.getProviderName());

	}
}
