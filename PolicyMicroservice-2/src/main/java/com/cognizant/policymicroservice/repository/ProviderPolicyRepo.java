package com.cognizant.policymicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.policymicroservice.model.ProviderPolicy;

public interface ProviderPolicyRepo extends JpaRepository<ProviderPolicy, Integer>{


	ProviderPolicy save(ProviderPolicy providers);

	
	List<ProviderPolicy> findAllByPolicyIdOrderByLocation(int PolicyId);

	
	

}