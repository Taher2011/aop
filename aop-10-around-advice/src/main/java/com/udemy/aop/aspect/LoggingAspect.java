package com.udemy.aop.aspect;

import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	/*
	 * Around advice is combination of @Before and @Afer advice, but gives us more
	 * fine-grained control
	 * 
	 * ProceedingJoinPoint is handle to the target method and can use
	 * proceedingJoinPoint to execute target method
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

	@Around("execution(* *Accounts(..))")
	public Object aroundAdviceOnAnyMethodOfAnyRetrunTypeEndsWithAccounts(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {

		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("Started executing @Around advice on " + method + " method");

		long begin = System.currentTimeMillis();

		Object object = null;

		try {
			object = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			// we can also re-throw exception object
			// throw e;
			object = new ArrayList<>();
		}

		long end = System.currentTimeMillis();

		long duration = end - begin;
		System.out.println("Duration : " + duration / 1000.0 + " seconds ");
		System.out.println("Completed executing @Around advice on " + method + " method");
		return object;
	}
}
