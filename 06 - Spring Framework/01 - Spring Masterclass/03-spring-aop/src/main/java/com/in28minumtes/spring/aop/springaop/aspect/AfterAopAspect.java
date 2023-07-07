package com.in28minumtes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class AfterAopAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@After("execution(* com.in28minumtes.spring.aop.springaop.business.*.*(..))")
	public void afterReturning(JoinPoint joinPoint) {
		logger.info("After execution of {}", joinPoint);
	}
	
	@AfterReturning(
			value="execution(* com.in28minumtes.spring.aop.springaop.business.*.*(..))",
			returning="result"
			)
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("{} returned with value {}", joinPoint, result);
	}
	
	@AfterThrowing(
			value="execution(* com.in28minumtes.spring.aop.springaop.business.*.*(..))",
			throwing="exception"
			)
	public void afterThrowing(JoinPoint joinPoint, Object exception) {
		logger.info("{} throw exception {}", joinPoint, exception);
	}
	
}
