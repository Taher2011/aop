package com.udemy.aop.dao;

import org.springframework.stereotype.Component;

import com.udemy.aop.model.Account;

@Component
public class AccountDAO {

	private String name;

	private String number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void addAccount(Account account) {
		System.out.println(
				"adding account details to DB for " + account.getName() + " and for type " + account.getType());
	}

	public void deleteAccount(Boolean isDelete) {
		System.out.println("deleting account details from DB");
	}

}
