package com.cognizant.claimsmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.claimsmicroservice.model.Benefits;

@Repository
public interface BenefitRepo extends JpaRepository<Benefits, Integer> {

	Benefits findByBenefitId(int benefitId);

}