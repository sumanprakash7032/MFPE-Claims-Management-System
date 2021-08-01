package com.cognizant.claimsmicroservice.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.claimsmicroservice.model.ProviderPolicy;
@SpringBootTest
@RunWith(SpringRunner.class)
class PolicyClientTest {

	@Mock
	PolicyClient policyClient;
	
	List<ProviderPolicy> providers;
	@BeforeEach
	void setUp() throws Exception {
		providers = new ArrayList<>();
		ProviderPolicy p1 = new ProviderPolicy();
		ProviderPolicy p2 = new ProviderPolicy();
		ProviderPolicy p3 = new ProviderPolicy();
		p1.setPolicyId(1);
		p2.setPolicyId(1);
		p3.setPolicyId(1);
		p1.setLocation("Hyderabad");
		p2.setLocation("Hyderabad");
		p3.setLocation("Hyderabad");
		p1.setProviderAddress("asa");
		p2.setProviderAddress("awa");
		p3.setProviderAddress("wer");
		p1.setProviderId(1);
		p2.setProviderId(2);
		p3.setProviderId(3);
		p1.setProviderName("ABC hospital");
		p2.setProviderName("XYZ hospital");
		p3.setProviderName("mno hospital");
		providers.add(p1);
		providers.add(p2);
		providers.add(p3);
	}

	@Test
	void policyClientIsLoadedtest() {
		 assertThat(policyClient).isNotNull();   
	}
	
	@Test
	void getChainOfProviders() {
		when(policyClient.getChainOfProviders(1,"dummy-token")).thenReturn(providers);
	
		//Mockito.doReturn(providers).when(policyClient.getChainOfProviders(1,"dummy-token"));
		assertEquals(providers, policyClient.getChainOfProviders(1,"dummy-token")); 
		
		
	}

}
