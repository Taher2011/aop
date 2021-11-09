package com.udemy.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.udemy.aop.AOPConfig;
import com.udemy.aop.dao.AccountDAO;
import com.udemy.aop.dao.UserDAO;

public class MainApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		accountDAO.addAccount();

		System.out.println();

		UserDAO userDAO = context.getBean("userDAO", UserDAO.class);

		userDAO.addUser();

		context.close();
	}

}
