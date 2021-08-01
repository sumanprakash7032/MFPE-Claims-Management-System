package com.cognizant.authorizationService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is the model class for username, password, token
 */ 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "myuser")
public class MyUser {

	@Id
	@Column(name = "memberid")
	private int memberid;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	//private String token;

	/*public MyUser(String memberid, String username, String password) {
		super();
		this.memberid = memberid;
		this.username = username;
		this.password = password;
	}*/
}
