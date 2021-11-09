package com.udemy.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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

	private static Logger LOGGER = Logger.getLogger(LoggingAspect.class.getName());
	
	@Around("execution(* *Accounts(..))")
	public Object aroundAdviceOnAnyMethodOfAnyRetrunTypeEndsWithAccounts(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {

		String method = proceedingJoinPoint.getSignature().toShortString();
		LOGGER.info("Started executing @Around advice on " + method + " method");

		long begin = System.currentTimeMillis();

		Object object = proceedingJoinPoint.proceed();

		long end = System.currentTimeMillis();

		long duration = end - begin;
		LOGGER.info("Duration : " + duration / 1000.0 + " seconds ");
		LOGGER.info("Completed executing @Around advice on " + method + " method");
		return object;
	}
}
