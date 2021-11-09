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

		List<Account> accounts = accountDAO.findAccounts();

		System.out.println();
		
		for (Account account : accounts) {
			System.out.println("account holder name : " + account.getName() + " and level is " + account.getLevel());
		}

		
		System.out.println();
		
		accountDAO.getAccounts();
		
		context.close();

	}

}
