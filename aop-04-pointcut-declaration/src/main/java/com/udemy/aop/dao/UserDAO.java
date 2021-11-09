package com.udemy.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {

	public void addUser() {
		System.out.println("Adding user details to DB");
	}

}
