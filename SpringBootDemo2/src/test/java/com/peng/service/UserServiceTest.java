package com.peng.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.peng.pojo.User;

public class UserServiceTest {
	UserService userService=new UserService();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindOne() {
		User user=new User();
		user.setId(1);
		User suser=userService.findOne(user);
		System.out.println(suser);
	}

}
