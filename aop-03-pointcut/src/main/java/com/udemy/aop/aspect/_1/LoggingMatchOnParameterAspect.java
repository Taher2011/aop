package com.udemy.aop.aspect._1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingMatchOnParameterAspect {

	/* Match on method parameter using wild-cards */

	/* 1) () -> matches a method with no arguments */
	@Before("execution(* addAccount())")
	public void beforeAdviceonAddAccount() {
		System.out.println("Executing @Before advice on addAccount() methods with any return-type in any class");
	}

	/* 2) (*) -> matches a method with one argument of any type */
	@Before("execution(* addAccount(*))")
	public void beforeAdviceonAddAccountWithOneParam() {
		System.out.println(
				"Executing @Before advice on addAccount() methods with one param of any type and any return-type in any class");
	}

	/* 3) (..) -> matches a method with 0 or more arguments of any type */
	@Before("execution(* addAccount(..))")
	public void beforeAdviceonAddAccountWithAnyParam() {
		System.out.println(
				"Executing @Before advice on addAccount() methods with 0 or more param of any type and any return-type in any class");
	}

}
