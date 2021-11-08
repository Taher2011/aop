package com.udemy.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	private String name = "Taher";

	private String number = "12345";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Name is " + this.name);
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
		System.out.println("Number is " + this.number);
	}

	public void addAccount() {
		System.out.println("Adding account details to DB");
	}

	public void deleteAccount() {
		System.out.println("Deleting account details from DB");
	}

}
