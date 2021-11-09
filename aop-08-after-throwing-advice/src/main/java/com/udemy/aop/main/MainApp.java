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

		try {
			boolean isAllow = false;
			accounts = accountDAO.findAccounts(isAllow);
		} catch (Exception e) {
			System.out.println("Exception caught " + e);
		}

		System.out.println();

		accountDAO.getAccounts();

		context.close();

	}

}
