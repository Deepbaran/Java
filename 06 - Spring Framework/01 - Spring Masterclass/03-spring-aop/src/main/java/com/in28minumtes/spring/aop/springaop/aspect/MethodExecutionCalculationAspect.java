package com.in28minumtes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Around("execution(* com.in28minumtes.spring.aop.springaop.business.*.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		// Do something before the method call is executed.
		long startTime = System.currentTimeMillis();
		
		joinPoint.proceed(); //This will allow the method call to proceed execution

		// Do something after the method call is executed
		long timeTaken = System.currentTimeMillis() - startTime;
		
		logger.info("Time taken by {} is {}", joinPoint, timeTaken);
	}
		
}
