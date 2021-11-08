package com.udemy.aop.dao;

import org.springframework.stereotype.Component;

import com.udemy.aop.model.Account1;

@Component
public class AccountDAO2 {

	public void addAccount(Account1 account) {
		System.out.println(getClass() + " " + "Adding account details to DB");
	}

}
