package com.udemy.aop.aspect._2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectOnAnyReturnTypeAspect {

	/* Match on return-types using wild-cards */

	/*
	 * 1) Match methods with any return-types start with add() in any class
	 */

	@Before("execution(public * add*())")
	public void beforeAccountAdvice() {
		System.out.println("Executing @Before advice on methods with any return-types start with add() in any class");
	}

}
