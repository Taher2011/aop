package com.udemy.aop.aspect._1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(* addAccount())")
	public void forAddAccount() {

	}

	@Before("forAddAccount()")
	public void loggingBeforeAddAccount() {
		System.out.println("applying @Before advice for logging on addAccount()");
	}

	@Before("forAddAccount()")
	public void securityBeforeAddAccount() {
		System.out.println("applying @Before advice for security on addAccount()");
	}

	@Before("forAddAccount()")
	public void trxBeforeAddAccount() {
		System.out.println("applying @Before advice for trx on addAccount()");
	}

}
