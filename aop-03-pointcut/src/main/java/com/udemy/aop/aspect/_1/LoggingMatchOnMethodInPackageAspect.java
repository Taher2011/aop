package com.udemy.aop.aspect._1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingMatchOnMethodInPackageAspect {

	/* Match on method in a package using wild-cards */

	/* 1) () -> matches any method in our DAO package -> com.udemy.aop.dao */
	@Before("execution(* com.udemy.aop.dao.*.*(..))")
	public void beforeAdviceonAddAccount() {
		System.out.println(
				"Executing @Before advice on any method in our DAO package with any return-type and with 0 or more param of any type in any class");
	}

}
