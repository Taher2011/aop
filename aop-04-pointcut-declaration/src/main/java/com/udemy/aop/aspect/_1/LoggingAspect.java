package com.udemy.aop.aspect._1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(* addAccount())")
	public void anyReturnTypeWithMethodNameAddAccountWithNoParam() {
	}

	@Pointcut("execution(* addUser())")
	public void anyReturnTypeWithMethodNameAddUserWithNoParam() {
	}

	@Before("anyReturnTypeWithMethodNameAddAccountWithNoParam() || anyReturnTypeWithMethodNameAddUserWithNoParam()")
	public void loggingBefore() {
		System.out.println("applying @Before advice for logging");
	}

	@Before("anyReturnTypeWithMethodNameAddAccountWithNoParam()")
	public void securityBefore() {
		System.out.println("applying @Before advice for security");
	}

	@Before("anyReturnTypeWithMethodNameAddAccountWithNoParam()")
	public void trxBefore() {
		System.out.println("applying @Before advice for trx");
	}

}
