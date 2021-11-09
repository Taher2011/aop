package com.udemy.aop.aspect._1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(* com.udemy.aop.dao.*.*(..))")
	public void anyMethodOfDaoPackage() {
	}

	@Pointcut("execution(* com.udemy.aop.dao.*.set*(..))")
	public void anyMethodStartWithSetOfDaoPackage() {
	}

	@Pointcut("execution(* com.udemy.aop.dao.*.get*(..))")
	public void anyMethodStartWithGetOfDaoPackage() {
	}

	@Pointcut("anyMethodOfDaoPackage() && !(anyMethodStartWithGetOfDaoPackage() || anyMethodStartWithSetOfDaoPackage())")
	public void anyMethodExcludingSetterGetterOfDaoPackage() {
	}

	@Before("anyMethodOfDaoPackage()")
	public void beforeAdviceOnAnyMethodOfDaoPackage() {
		System.out.println("applying before advice on dao methods");
	}

	@Before("anyMethodExcludingSetterGetterOfDaoPackage()")
	public void beforeAdviceOnAnyMethodExcludingSetterGetterOfDaoPackage() {
		System.out.println("applying before advice on dao methods but not on getter/setter");
	}
}
