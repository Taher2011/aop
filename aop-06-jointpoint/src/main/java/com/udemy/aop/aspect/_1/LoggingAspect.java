package com.udemy.aop.aspect._1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.udemy.aop.model.Account;

@Aspect
@Component
public class LoggingAspect {

	// JointPoint has metadata about method call

	@Pointcut("execution(* com.udemy.aop.dao.*.*(..))")
	public void allMethodOfDaoPackagePointCut() {
	}

	@Before("allMethodOfDaoPackagePointCut()")
	public void beforeAdviceOnMethod(JoinPoint joinPoint) {
		System.out.println("applying @Before advice");

		// display method signature
		Signature signature = joinPoint.getSignature();
		System.out.println("Method signature : " + signature);

		// display method arguments
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			System.out.println("Method argument : " + arg);
			if (arg instanceof Account) {
				Account account = (Account) arg;
				System.out.println("Name : " + account.getName());
				System.out.println("Type : " + account.getType());
			}
		}
	}

}
