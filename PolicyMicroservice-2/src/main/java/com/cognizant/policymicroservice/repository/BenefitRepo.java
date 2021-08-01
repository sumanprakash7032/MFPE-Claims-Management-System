package com.cognizant.policymicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.policymicroservice.model.Benefits;

public interface BenefitRepo extends JpaRepository<Benefits, Integer> {

	public Benefits findByBenefitId(int benefitId);

}