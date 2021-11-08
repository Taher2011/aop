package com.udemy.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {

	public boolean addUser() {
		System.out.println(getClass() + " " + "Adding user details to DB");
		return true;
	}

}
