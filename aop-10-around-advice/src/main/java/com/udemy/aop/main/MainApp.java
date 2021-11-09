package com.udemy.aop.main;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.udemy.aop.AOPConfig;
import com.udemy.aop.dao.AccountDAO;
import com.udemy.aop.model.Account;

public class MainApp {

	private static Logger LOGGER = Logger.getLogger(MainApp.class.getName());

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = accountDAO.findAccounts(new Account("Taher", "Gold"));

		LOGGER.info(accounts.toString());

		LOGGER.info("Finished");

		context.close();

	}

}
