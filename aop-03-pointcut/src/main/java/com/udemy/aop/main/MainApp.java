package com.udemy.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.udemy.aop.AOPConfig;
import com.udemy.aop.dao.AccountDAO1;
import com.udemy.aop.dao.AccountDAO2;
import com.udemy.aop.dao.AccountDAO3;
import com.udemy.aop.model.Account1;
import com.udemy.aop.model.Account2;

public class MainApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);

		AccountDAO1 accountDAO1 = context.getBean("accountDAO1", AccountDAO1.class);
		accountDAO1.addAccount();
		System.out.println();

		AccountDAO2 accountDAO2 = context.getBean("accountDAO2", AccountDAO2.class);
		accountDAO2.addAccount(new Account1());
		System.out.println();

		AccountDAO3 accountDAO3 = context.getBean("accountDAO3", AccountDAO3.class);
		accountDAO3.addAccount(new Account1(), new Account2());
		context.close();

	}

}
