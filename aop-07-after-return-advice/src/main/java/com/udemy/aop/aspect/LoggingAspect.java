package com.udemy.aop.aspect;

import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.udemy.aop.model.Account;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* *Accounts(..))")
	public void beforeAdviceOnAnyMethodOfAnyRetrunTypeEndsWithAccounts(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("Executing @Before advice on " + method + " method");
	}

	@AfterReturning(pointcut = "execution(* *Accounts(..))", returning = "accounts")
	public void afterReturningAdviceOnAnyMethodOfAnyRetrunTypeEndsWithAccounts(JoinPoint joinPoint,
			List<Account> accounts) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("Executing @AfterReturning advice on " + method + " method");

		// modify the name and make it to upper-case
		if (!accounts.isEmpty()) {
			accounts = accounts.stream().map(a -> {
				a.setLevel(a.getLevel().toUpperCase());
				a.setName(a.getName().toUpperCase());
				return a;
			}).collect(Collectors.toList());
		}

		System.out.println("Results are " + accounts);
	}

}
