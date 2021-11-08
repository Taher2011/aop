package com.udemy.aop.dao;

import org.springframework.stereotype.Component;

import com.udemy.aop.model.Account1;
import com.udemy.aop.model.Account2;

@Component
public class AccountDAO3 {

	public boolean addAccount(Account1 account1, Account2 account2) {
		System.out.println(getClass() + " " + "Adding account details to DB");
		return false;
	}

}
