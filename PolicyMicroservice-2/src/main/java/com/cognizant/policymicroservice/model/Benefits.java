package com.cognizant.policymicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * This is a model class used for object of type benefit
 */
@Entity
@Table(name = "benefits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Benefits {

	@Id
	@JsonProperty
	private int benefitId;
	@JsonProperty
	private String benefitName;
}
