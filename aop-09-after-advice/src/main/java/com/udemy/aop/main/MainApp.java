package com.udemy.aop.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.udemy.aop.AOPConfig;
import com.udemy.aop.dao.AccountDAO;
import com.udemy.aop.model.Account;

public class MainApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = null;

		System.out.println("===============================Fail Scenario started===============================");
		failScenario(accountDAO);
		System.out.println("===============================Fail Scenario ended=================================");

		System.out.println();

		System.out.println("===============================Success Scenario started============================");
		succsesScenario(accountDAO);
		System.out.println("===============================Success Scenario ended==============================");

		System.out.println();

		accountDAO.getAccounts();

		context.close();

	}

	private static void failScenario(AccountDAO accountDAO) {
		List<Account> accounts;
		try {
			boolean isAllow = false;
			accounts = accountDAO.findAccounts(isAllow);
		} catch (Exception e) {
			System.out.println("Exception caught " + e);
		}
	}

	private static void succsesScenario(AccountDAO accountDAO) {
		List<Account> accounts;
		try {
			boolean isAllow = true;
			accounts = accountDAO.findAccounts(isAllow);
		} catch (Exception e) {
			System.out.println("Exception caught " + e);
		}
	}

}
