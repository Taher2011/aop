package com.udemy.aop.aspect._1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(* com.udemy.aop.dao.*.*(..))")
	public void beforeAdviceOnDaoMethod() {
	}

	@Pointcut("execution(* com.udemy.aop.dao.*.set*(..))")
	public void setter() {
	}

	@Pointcut("execution(* com.udemy.aop.dao.*.get*(..))")
	public void getter() {
	}

	@Pointcut("beforeAdviceOnDaoMethod() && !(getter() || setter())")
	public void forDaoMethodNoGetterSetter() {
	}

	@Before("beforeAdviceOnDaoMethod()")
	public void beforeAdviceOnDaoMethods() {
		System.out.println("applying before advice on dao methods");
	}
	
	@Before("forDaoMethodNoGetterSetter()")
	public void beforeAdviceOnDaoMethodsNoGetterSetter() {
		System.out.println("applying before advice on dao methods but not on getter/setter");
	}
}
