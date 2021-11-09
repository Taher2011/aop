package com.udemy.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.udemy.aop.model.Account;

@Component
public class AccountDAO {

	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<>();
		Account account1 = new Account("Taher", "Gold");
		Account account2 = new Account("Amit", "Silver");
		Account account3 = new Account("John", "Platinum");
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		return accounts;
	}

}
