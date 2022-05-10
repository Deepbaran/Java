package com.in28minumtes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class UserAccessAspect {
	
	// Typically we would use it to check for access. To check if the user has the right access before we allow the user to execute the method.
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	//What kind of method calls I would intercept
	//Pointcut/JoinPoint
	//execution(* PACKAGE.*.*(..)) <- Intercept all methods irrespective of their return types, in a specific PACKAGE, in any class, intercept all method calls irrespective of their arguments 
	//execution(* com.in28minumtes.spring.aop.springaop..*.*(..)) <- Access all method calls inside all the sub packages of com.in28minumtes.spring.aop.springaop
//	@Before("execution(* com.in28minumtes.spring.aop.springaop.business.*.*(..))")
	@Before("com.in28minumtes.spring.aop.springaop.aspect.CommonJoinPointConfig.businessExecution()")
	public void before(JoinPoint joinPoint) { //joinPoint is the exact pointcut expression of the method call
		//Advise
		logger.info("Check for User Access ");
		logger.info("Allowed execution for {}", joinPoint);
	}
	
	
	@Before("com.in28minumtes.spring.aop.springaop.aspect.CommonJoinPointConfig.dataLayerExecution()") //We can use this instead of using the pointcut directly.
	public void before2(JoinPoint joinPoint) {
		logger.info("Check for User Access ");
		logger.info("Allowed execution for {}", joinPoint);
	}
	
}
