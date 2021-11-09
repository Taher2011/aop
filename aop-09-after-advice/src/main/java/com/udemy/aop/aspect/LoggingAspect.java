package com.udemy.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	/*
	 * After advice will always execute regardless of failure or success of target
	 * method, just like finally block
	 */

	@Before("execution(* *Accounts(..))")
	public void beforeAdviceOnAnyMethodOfAnyRetrunTypeEndsWithAccounts(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("Executing @Before advice on " + method + " method");
	}

	@AfterThrowing(pointcut = "execution(* *Accounts(..))", throwing = "excp")
	public void afterThrowingAdviceOnAnyMethodOfAnyRetrunTypeEndsWithAccounts(JoinPoint joinPoint, Throwable excp) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("Executing @AfterThrowing advice on " + method + " method");

		System.out.println("Exception is " + excp);
	}

	@AfterReturning("execution(* *Accounts(..))")
	public void afterReturningAdviceOnAnyMethodOfAnyRetrunTypeEndsWithAccounts(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("Executing @AfterReturning advice on " + method + " method");
	}

	@After("execution(* *Accounts(..))")
	public void afterAdviceOnAnyMethodOfAnyRetrunTypeEndsWithAccounts(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("Executing @After advice on " + method + " method");
	}

}
