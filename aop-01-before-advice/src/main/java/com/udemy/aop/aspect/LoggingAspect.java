package com.udemy.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(public void addAccount())") // "execution(public void addAccount())" is pointcut, a just predicate expression for where advice should be applied
	public void beforeAccountAdvice() {
		System.out.println("Executing @Before advice on addAccount()");
	}

}
