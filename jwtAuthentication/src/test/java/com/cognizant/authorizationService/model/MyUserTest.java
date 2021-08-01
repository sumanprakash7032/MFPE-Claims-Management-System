package com.cognizant.authorizationService.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.authorizationService.model.MyUser;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyUserTest {

	@Mock
	MyUser myUser;

	@Test
	public void testAllArgumentConstructor() {
		MyUser user = new MyUser(1, "admin", "admin");
		assertEquals(1, user.getMemberid());
		assertEquals("admin", user.getUsername());
		assertEquals("admin", user.getPassword());
		//assertEquals(" ", user.getToken());
	}

	@Test
	public void testNoArgumentConstructor() {
		MyUser user = new MyUser();
		assertEquals(user, user);
	}

	@Test
	public void testSetter() {
		MyUser user = new MyUser();
		user.setUsername("abc");
		assertEquals("abc", user.getUsername());
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = myUser.equals(myUser);
		assertTrue(equals);
	}

	@Test
	void testingMyUser() {
		myUser = new MyUser(1, "suman", "suman");
		myUser.setMemberid(1);
		myUser.setUsername("suman");
		myUser.setPassword("suman");

		assertEquals(1, myUser.getMemberid());
		assertEquals("suman", myUser.getUsername());
		assertEquals("suman", myUser.getPassword());

	}
}
