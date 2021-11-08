package com.udemy.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.udemy.aop.AOPConfig;
import com.udemy.aop.dao.AccountDAO;

public class MainApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		accountDAO.addAccount();

		System.out.println();

		accountDAO.deleteAccount();

		System.out.println();

		accountDAO.setName("Taher");

		System.out.println();

		accountDAO.setNumber("12345");
		
		System.out.println();

		System.out.println(accountDAO.getName());
		
		System.out.println();
		
		System.out.println(accountDAO.getNumber());

		context.close();
	}

}
