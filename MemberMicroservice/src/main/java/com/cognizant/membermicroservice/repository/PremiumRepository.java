package com.cognizant.membermicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.membermicroservice.model.MemberPremium;

/**
 * 
 * This interface communicates with database to fetch the premium details.
 *
 */

@Repository
public interface PremiumRepository extends JpaRepository<MemberPremium, Integer> {

	/**
	 * 
	 * @param policyId
	 * @return List<MemberPremium>
	 */

	public List<MemberPremium> findBypolicyId(Integer policyId);

	/**
	 * 
	 * @param memberId
	 * @return List<MemberPremium>
	 */

	public List<MemberPremium> findBymemberId(Integer memberId);

}