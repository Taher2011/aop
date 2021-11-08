package com.udemy.aop.aspect._1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingMatchOnMethodAspect {

	/* Match on method names using wild-cards */

	/* 1) Match methods with void return-type starting with add() in any class */

	@Before("execution(public void add*())")
	public void beforeAccountAdvice() {
		System.out.println("Executing @Before advice on any methods with void return-type starting with add() in any class");
	}

	/* 2) Match methods starting with processCreditCards() in any class */

	@Before("execution(public void processCreditCards*())")
	public void beforeCreditCardsAdvice() {
		System.out.println("Executing @Before advice on processCreditCards()");
	}

}
