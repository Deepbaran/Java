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
	//execution(returnType package.subPackage.class.method(args))
	//execution(* com.in28minumtes.spring.aop.springaop..*.*(..)) <- Access all method calls inside all the sub packages of com.in28minumtes.spring.aop.springaop
	
//	@Before("execution(* com.in28minumtes.spring.aop.springaop.business.*.*(..))") // For all the methods with any return type in all the classes in the business package
	@Before("com.in28minumtes.spring.aop.springaop.aspect.CommonJoinPointConfig.businessExecution()")
	public void before(JoinPoint joinPoint) { //joinPoint is the exact pointcut expression of the method call
		//Suppose we wish to check if the user has the right access to the Beans or not before the user can access them. In that situation we can use it.
		//Using this will make it easier to check the user access for all beans rather than implementing the checking in individual beans.
		// Advice
		logger.info("Check for User Access ");
		logger.info("Allowed execution for {}", joinPoint);
	}
	
	
	@Before("com.in28minumtes.spring.aop.springaop.aspect.CommonJoinPointConfig.dataLayerExecution()") //We can use this instead of using the pointcut directly.
	public void before2(JoinPoint joinPoint) {
		logger.info("Check for User Access ");
		logger.info("Allowed execution for {}", joinPoint);
	}
	
}
