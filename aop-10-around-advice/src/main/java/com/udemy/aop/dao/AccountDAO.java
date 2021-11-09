package com.udemy.aop.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.udemy.aop.model.Account;

@Component
public class AccountDAO {

	public List<Account> findAccounts(Account account) {
		System.out.println("started adding accounts");

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("completed adding accounts");
		List<Account> accounts = new ArrayList<>();
		accounts.add(account);
		if (false) {
			throw new RuntimeException();
		}
		return accounts;
	}

}
